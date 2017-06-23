package spring.core.loggers;

import spring.core.beans.EventLogger;

/**
 * Created by Evgeniy on 23.06.2017.
 */
public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(String message) {
        System.out.println(message);
    }
}
