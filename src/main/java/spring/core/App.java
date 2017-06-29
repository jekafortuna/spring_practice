package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.loggers.ConsoleEventLogger;
import spring.core.loggers.EventLogger;

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

//        app.logEvent("Some event for user 2");

        app.logEvents(context);
        context.close();
    }

    public void logEvents(ApplicationContext context){
        Event event = context.getBean(Event.class);
        logEvent(event, "Some event for user 2");
    }

    private void logEvent(Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
