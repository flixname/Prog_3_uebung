package eventSystem.infrastructure;

import java.util.EventObject;

public class ExitEvent extends EventObject {
    public ExitEvent(Object source) {
        super(source);
    }
}
