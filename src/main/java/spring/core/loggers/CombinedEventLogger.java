package spring.core.loggers;

import spring.core.beans.Event;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Evgeniy on 13.07.2017.
 * Combined event logger class
 */
public class CombinedEventLogger extends AbstractLogger{

    /**
     * Collection of loggers in application
     */
    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers){
            eventLogger.logEvent(event);
        }
    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
}
