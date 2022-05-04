package eventSystem.infrastructure;

import java.util.EventListener;

public interface UpdateEventListener extends EventListener {
    void onIncrementEvent(UpdateEvent updateEvent);
}