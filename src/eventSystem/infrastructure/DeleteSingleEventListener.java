package eventSystem.infrastructure;

import java.util.EventListener;

public interface DeleteSingleEventListener extends EventListener {
    void onDeleteEvent(DeleteSingleContentEvent deleteSingleContentEvent);
}
