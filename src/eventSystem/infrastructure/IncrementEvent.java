package eventSystem.infrastructure;

import java.util.EventObject;

public class IncrementEvent extends EventObject {

    public IncrementEvent(Object source) {
        super(source);
    }
}
