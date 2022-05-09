package eventSystem.infrastructure;

import mediaDB.AudioVideo;

import java.util.EventObject;

public class CreateEvent extends EventObject {

    AudioVideo content;

    public CreateEvent(Object source) {
        super(source);
    }

    public AudioVideo getContent() {
        return content;
    }
}
