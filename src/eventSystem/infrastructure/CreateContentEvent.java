package eventSystem.infrastructure;

import mediaDB.AudioVideo;
import mediaDB.Content;

import java.util.EventObject;

public class CreateContentEvent extends EventObject {

    Content content;

    public CreateContentEvent(Object source) {
        super(source);
    }

    public Content getContent() {
        return content;
    }
}
