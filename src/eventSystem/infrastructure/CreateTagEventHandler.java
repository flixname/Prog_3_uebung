package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class CreateTagEventHandler {
    private List<CreateTagEventListener> listenerList = new LinkedList<>();

    public void add(CreateTagEventListener listener) { this.listenerList.add(listener); }

    public void remove(CreateTagEventListener listener) { this.listenerList.remove(listener); }

    public void handle(CreateTagEvent event){ for (CreateTagEventListener listener : listenerList) listener.onCreateTagEvent(event); }
}
