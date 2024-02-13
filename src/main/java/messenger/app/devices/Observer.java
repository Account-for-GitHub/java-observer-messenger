package messenger.app.devices;

import messenger.app.informer.ISubject;

public abstract class Observer {
    ISubject subject;

    public void updateMessage() {
        if (subject == null) return;
        System.out.println(
                this.getClass().getSimpleName() + " successfully received message "
                        + '"' + this.subject.getMessage() + '"' + "!"
        );
    }
}
