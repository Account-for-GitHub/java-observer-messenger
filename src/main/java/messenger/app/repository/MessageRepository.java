package messenger.app.repository;

import messenger.app.informer.Message;
import org.springframework.data.repository.*;
public interface MessageRepository extends CrudRepository<Message, String> {}
