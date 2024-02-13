package messenger.app.informer;

import messenger.app.devices.Observer;

public interface ISubject {
    void registerObserver(Observer o);
    void excludeObserver(Observer o);
    void informObservers();

    String getMessage();
}
