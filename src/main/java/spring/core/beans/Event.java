package spring.core.beans;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Evgeniy on 24.06.2017.
 * Event class of application
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(int id, String msg, Date date) {
        this.id = id;
        this.msg = msg;
        this.date = date;
    }

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (msg != null ? !msg.equals(event.msg) : event.msg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event {" + "id = " + id + ", msg = '" + msg + '\'' +
                ", date = " + date + ", dateFormat = " + dateFormat.format(date) + '}';
    }
}
