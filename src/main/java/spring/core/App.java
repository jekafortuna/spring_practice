package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.beans.EventType;
import spring.core.loggers.EventLogger;

import java.util.Map;

/**
 * Created by Evgeniy on 23.06.2017.
 * Main class of application
 */
public class App {
    /**
     * Client unit
     */
    private Client client;
    /**
     * Default event logger
     */
    private EventLogger defaultLogger;
    /**
     * Map of loggers with their types
     */
    private Map<EventType, EventLogger> loggers;

    public App() {}

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml", "Loggers.xml");
        App app = (App) context.getBean("app");

        app.logEvents(context);
        context.close();
    }

    public void logEvents(ApplicationContext context){
        Event event = context.getBean(Event.class);
        logEvent(EventType.INFO, event, "Some event for user 2");

        event = context.getBean(Event.class);
        logEvent(EventType.ERROR, event, "Some event for user 2");

        event = context.getBean(Event.class);
        logEvent(EventType.ERROR, event, "Some event for 1");

        event = context.getBean(Event.class);
        logEvent(null, event, "Null event");
    }

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
