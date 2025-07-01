package com.example;

public class MyService {
    private ExternalApi api;
    private Notifier notifier;
    private Logger logger;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public MyService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void performActionAndNotify(String message) {
        // Imagine it does something useful here...
        if (notifier != null) {
            notifier.sendNotification(message);
        }
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchData(String id) {
        return api.getData(id);
    }

    public void doSomethingImportant() {
        // Imagine this is your important logic
        notifier.sendNotification("Important task done");
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void doImportantWorkflow() {
        if (logger != null) {
            logger.log("Starting workflow");
        }

        String data = api.getData(); // simulated work

        if (notifier != null) {
            notifier.sendNotification("Workflow completed");
        }
    }
}
