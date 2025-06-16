public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setStrategy(new CreditCardPayment("1234567890123456"));
        context.payAmount(1000.00);

        // Pay using PayPal
        context.setStrategy(new PayPalPayment("aayush@email.com"));
        context.payAmount(750.50);
    }
}
