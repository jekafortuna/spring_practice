package spring.core.loggers;

import spring.core.beans.Event;

/**
 * Created by Evgeniy on 23.06.2017.
 */
public interface EventLogger {
    public void logEvent(Event event);
    public String getName();
}
