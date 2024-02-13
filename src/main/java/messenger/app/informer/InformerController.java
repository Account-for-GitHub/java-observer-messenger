package messenger.app.informer;

import messenger.app.devices.Observer;
import messenger.app.repository.MessageRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class InformerController implements ISubject {
    private final MessageRepository repository;
    ArrayList<Observer> observers = new ArrayList<>();
    private String message = "";

    public InformerController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    String receiveMessageToSend(@RequestBody Message entity) {
        message = entity.getMessage();
        try {
            informObservers();
        } catch (Exception e) {
            return "Failure!";
        }
        //TODO save to db
        repository.save(entity);
        return "Success!";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void excludeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void informObservers() {
        observers.forEach(Observer::updateMessage);
    }

    public String getMessage() {
        return message;
    }
}