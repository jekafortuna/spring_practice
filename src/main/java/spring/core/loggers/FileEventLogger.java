package spring.core.loggers;

import org.apache.commons.io.FileUtils;
import spring.core.beans.Event;

import java.io.File;
import java.io.IOException;

/**
 * Created by Evgeniy on 24.06.2017.
 * File event logger class
 */
public class FileEventLogger extends AbstractLogger {
    /**
     * name of file for logging
     */
    private String fileName;
    /**
     * file for logging
     */
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    /**
     * checks existing of file for logging. Otherwise creates this file
     * @throws IOException
     */
    public void init() throws IOException{
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()){
            file.createNewFile();
        }
    }

    /**
     * logging event into file
     * @param event
     */
    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
