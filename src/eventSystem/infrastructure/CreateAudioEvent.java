package eventSystem.infrastructure;

import java.util.EventObject;

public class CreateAudioEvent extends EventObject {
    public CreateAudioEvent(Object source) {
        super(source);
    }
}
