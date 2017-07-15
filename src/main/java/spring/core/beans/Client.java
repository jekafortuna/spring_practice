package spring.core.beans;

/**
 * Created by Evgeniy on 23.06.2017.
 * Client class of application
 */
public class Client {
    /**
     * id of client
     */
    private String id;
    /**
     * full name of client
     */
    private String fullName;
    /**
     * greeting of client
     */
    private String greeting;

    public Client() {
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
