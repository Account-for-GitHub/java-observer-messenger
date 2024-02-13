package messenger.app.informer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Message {
    @Id
    @UuidGenerator
    private String id;
    private String message;

    public Message() {
    }

    public Message(String m) {
//        id = UUID.randomUUID().toString();
        message = m;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
