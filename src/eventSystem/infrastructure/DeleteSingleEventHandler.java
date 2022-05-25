package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class DeleteSingleEventHandler {
    private List<DeleteSingleEventListener> listenerList = new LinkedList<>();

    public void add(DeleteSingleEventListener listener) { this.listenerList.add(listener); }

    public void remove(DeleteSingleEventListener listener) { this.listenerList.remove(listener); }

    public void handle(DeleteSingleContentEvent event){ for (DeleteSingleEventListener listener : listenerList) listener.onDeleteEvent(event); }
}
