package spring.core;

import spring.core.beans.Client;
import spring.core.loggers.ConsoleEventLogger;

/**
 * Created by Evgeniy on 23.06.2017.
 */
public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App() {
    }

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("2", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 2");
    }

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
