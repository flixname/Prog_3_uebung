package eventSystem.infrastructure;


import mediaDB.Audio;

import java.util.EventObject;

public class CreateAudioEvent extends EventObject {

    public CreateAudioEvent(Object source) {
        super(source);
    }
}
