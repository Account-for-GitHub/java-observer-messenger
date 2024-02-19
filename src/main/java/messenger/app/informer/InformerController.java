package messenger.app.informer;

import messenger.app.devices.Observer;
import messenger.app.repository.RepositoryWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class InformerController implements ISubject {
    private final RepositoryWrapper repositoryWrapper;
    ArrayList<Observer> observers = new ArrayList<>();
    private String message = "";

    public InformerController(RepositoryWrapper repositoryWrapper) {
        this.repositoryWrapper = repositoryWrapper;
    }

    @PostMapping("/")
    ResponseEntity<String> receiveMessageToSend(@RequestBody Message entity) {
        message = entity.getMessage();
        try {
            informObservers();
        } catch (Exception e) {
            return new ResponseEntity<>("Failure!", HttpStatus.EXPECTATION_FAILED);
        }
        repositoryWrapper.save(entity);
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    @GetMapping("/show-all-messages")
    Iterable<Message> showAll() {
        return repositoryWrapper.findAll();
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