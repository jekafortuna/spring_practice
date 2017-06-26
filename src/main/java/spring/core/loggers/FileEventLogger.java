package spring.core.loggers;

import org.apache.commons.io.FileUtils;
import spring.core.beans.Event;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgeniy on 24.06.2017.
 */
public class FileEventLogger extends AbstractLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
