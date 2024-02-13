package messenger.app.init;

import jakarta.annotation.PostConstruct;
import messenger.app.devices.FirstDevice;
import messenger.app.devices.SecondDevice;
import messenger.app.devices.ThirdDevice;
import messenger.app.informer.InformerController;
import org.springframework.stereotype.Component;

@Component
public class InitiationDataLoader {

    private final InformerController controller;

    public InitiationDataLoader(InformerController controller) {
        this.controller = controller;
    }

    @PostConstruct
    void loadInitiationData() {
        setObserverDevices();
    }

    void setObserverDevices() {
        new FirstDevice(controller);
        new SecondDevice(controller);
        new ThirdDevice(controller);
    }
}
