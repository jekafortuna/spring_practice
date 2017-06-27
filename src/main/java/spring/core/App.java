package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
//        App app = new App();
//        app.client = new Client("2", "John Smith");
//        app.eventLogger = new ConsoleEventLogger();
//        app.logEvent("Some event for user 1");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml", "Loggers.xml");
        App app = (App) context.getBean("app");

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");

        context.close();
    }

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
//        eventLogger.logEvent(message);
    }
}
