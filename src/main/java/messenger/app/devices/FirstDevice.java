package messenger.app.devices;

import messenger.app.informer.ISubject;
import org.jetbrains.annotations.NotNull;

public class FirstDevice extends Observer {
    public FirstDevice(@NotNull ISubject s) {
        subject = s;
        subject.registerObserver(this);
    }
}
