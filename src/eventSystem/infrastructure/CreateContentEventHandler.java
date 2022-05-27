package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class CreateContentEventHandler {
    private List<CreateContentEventListener> listenerList = new LinkedList<>();

    public void add(CreateContentEventListener listener) { this.listenerList.add(listener); }

    public void remove(CreateContentEventListener listener) { this.listenerList.remove(listener); }

    public void handle(CreateContentEvent event){ for (CreateContentEventListener listener : listenerList) listener.onCreateContentEvent(event); }

}
