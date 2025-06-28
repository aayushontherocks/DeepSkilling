-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60 years old
BEGIN
  FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
    IF MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12 > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;
END;
/

-- Scenario 2: Promote customers to VIP if balance > $10,000
-- Ensure IsVIP column exists
BEGIN
  EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP VARCHAR2(5))';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE = -01430 THEN
      NULL; -- column already exists
    ELSE
      RAISE;
    END IF;
END;
/

BEGIN
  FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;
END;
/

-- Scenario 3: Send reminders for loans due in the next 30 days
BEGIN
  FOR loan_rec IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan_rec.LoanID ||
                         ' for customer ' || loan_rec.Name ||
                         ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD'));
  END LOOP;
END;
/
