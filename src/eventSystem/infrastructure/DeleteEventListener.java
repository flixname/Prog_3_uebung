package eventSystem.infrastructure;

import java.util.EventListener;

public interface DeleteEventListener extends EventListener {
    void onDeleteEvent(DeleteEvent deleteEvent);
}
