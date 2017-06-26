package spring.core.loggers;

/**
 * Created by Evgeniy on 25.06.2017.
 */
public abstract class AbstractLogger implements EventLogger {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
