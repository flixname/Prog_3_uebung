package eventSystem.infrastructure;

import java.util.EventListener;

public interface CreateEventListener extends EventListener {
    void onCreateEvent(CreateEvent createEvent);
}
