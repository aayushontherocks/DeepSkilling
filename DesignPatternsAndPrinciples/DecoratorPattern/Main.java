public class Main {
    public static void main(String[] args) {
        // Base notifier
        Notifier baseNotifier = new EmailNotifier();

        // Add SMS and Slack notifications
        Notifier smsNotifier = (Notifier) new SMSNotifierDecorator(baseNotifier);
        Notifier slackAndSmsNotifier = (Notifier) new SlackNotifierDecorator(smsNotifier);

        // Send via all channels
        slackAndSmsNotifier.send("Decorator pattern test message!");
    }
}
