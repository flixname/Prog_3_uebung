package eventSystem.infrastructure;

import java.util.EventObject;

public class ReadEvent extends EventObject {
    public ReadEvent(Object source) {
        super(source);
    }
}
