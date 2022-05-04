package eventSystem.infrastructure;

import mediaDB.Content;

import java.util.EventObject;

public class CreateEvent extends EventObject {

    Content content;

    public CreateEvent(Object source) {
        super(source);
    }

    public Content getContent() {
        return content;
    }
}
