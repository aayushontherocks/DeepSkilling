-- 1️⃣ Update LastModified column whenever a customer is updated
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

-- 2️⃣ Insert audit log whenever a transaction is added
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    TransactionID,
    AccountID,
    Amount,
    TransactionType,
    LogDate
  ) VALUES (
    :NEW.TransactionID,
    :NEW.AccountID,
    :NEW.Amount,
    :NEW.TransactionType,
    SYSDATE
  );
END;
/

-- 3️⃣ Enforce business rules: deposits must be > 0, withdrawals must not exceed balance
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  IF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be positive.');
    END IF;
  ELSIF :NEW.TransactionType = 'Withdrawal' THEN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20002, 'Withdrawal amount exceeds current balance.');
    END IF;
  END IF;
END;
/
