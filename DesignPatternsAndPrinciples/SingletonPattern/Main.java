public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Same Logger instance used");
        } else {
            System.out.println("Different instances - Singleton failed");
        }
    }
}
