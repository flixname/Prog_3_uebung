package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class CreateEventHandler {

    private List<CreateEventListener> listenerList = new LinkedList<>();

    public void add(CreateEventListener listener) { this.listenerList.add(listener); }

    public void remove(CreateEventListener listener) { this.listenerList.remove(listener); }

    public void handle(CreateEvent event){ for (CreateEventListener listener : listenerList) listener.onCreateEvent(event); }

}
