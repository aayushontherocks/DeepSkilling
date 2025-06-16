public class EmailNotifier implements Notifier {

    public EmailNotifier() {
    }
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
