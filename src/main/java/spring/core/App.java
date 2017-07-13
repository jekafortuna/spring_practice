package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.beans.EventType;
import spring.core.loggers.ConsoleEventLogger;
import spring.core.loggers.EventLogger;

import java.util.Map;

/**
 * Created by Evgeniy on 23.06.2017.
 */
public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
//    private ConsoleEventLogger eventLogger;

    public App() {}

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
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
        logEvent(EventType.INFO, event, "Some event for user 2");

        event = context.getBean(Event.class);
        logEvent(EventType.ERROR, event, "Some event for 1");
    }

//    private void logEvent(Event event, String msg){
//        String message = msg.replaceAll(client.getId(), client.getFullName());
//        event.setMsg(message);
//        eventLogger.logEvent(event);
//    }

    private void logEvent(EventType type, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if (logger == null){
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
