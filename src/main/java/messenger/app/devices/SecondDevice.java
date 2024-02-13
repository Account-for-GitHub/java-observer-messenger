package messenger.app.devices;

import messenger.app.informer.ISubject;
import org.jetbrains.annotations.NotNull;

public class SecondDevice extends Observer {
    public SecondDevice(@NotNull ISubject s) {
        subject = s;
        subject.registerObserver(this);
    }
}
