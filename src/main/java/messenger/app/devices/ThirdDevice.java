package messenger.app.devices;

import messenger.app.informer.ISubject;
import org.jetbrains.annotations.NotNull;

public class ThirdDevice extends Observer {
    public ThirdDevice(@NotNull ISubject s) {
        subject = s;
        subject.registerObserver(this);
    }
}
