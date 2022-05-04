package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class DeleteEventHandler {
    private List<DeleteEventListener> listenerList = new LinkedList<>();

    public void add(DeleteEventListener listener) { this.listenerList.add(listener); }

    public void remove(DeleteEventListener listener) { this.listenerList.remove(listener); }

    public void handle(DeleteEvent event){ for (DeleteEventListener listener : listenerList) listener.onDeleteEvent(event); }
}
