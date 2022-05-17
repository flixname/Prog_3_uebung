package eventSystem.infrastructure;

import java.util.EventListener;

public interface CreateContentEventListener extends EventListener {
    void onCreateEvent(CreateEvent createEvent);
}
