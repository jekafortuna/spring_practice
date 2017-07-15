package spring.core.loggers;

import spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 27.06.2017.
 * Logger of cache, that writes into file
 */
public class CacheFileEventLogger extends FileEventLogger {

    /**
     * size of cache information
     */
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);
        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    /**
     * writes events on cache into loggers
     */
    private void writeEventsFromCache(){
        cache.stream().forEach(super::logEvent);
    }

    /**
     * writes the remains of cache into file
     */
    public void destroy(){
        if (!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
