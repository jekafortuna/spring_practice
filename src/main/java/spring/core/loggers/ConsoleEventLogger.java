package spring.core.loggers;

import spring.core.beans.Event;

/**
 * Created by Evgeniy on 23.06.2017.
 */
public class ConsoleEventLogger extends AbstractLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
