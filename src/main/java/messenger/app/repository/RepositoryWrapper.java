package messenger.app.repository;

import messenger.app.informer.Message;
import org.springframework.stereotype.Component;

@Component
public class RepositoryWrapper {
    private final MessageRepository repository;

    public RepositoryWrapper(MessageRepository repository) {
        this.repository = repository;
    }

    public Message save(Message entity) {
        return repository.save(entity);
    }

    public Iterable<Message> findAll() {
        return repository.findAll();
    }
}
