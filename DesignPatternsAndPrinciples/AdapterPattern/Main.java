public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter();

        paypalProcessor.processPayment(100.0);
    }
}
