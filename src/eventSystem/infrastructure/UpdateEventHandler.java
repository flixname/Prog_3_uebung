package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class UpdateEventHandler {

    private List<UpdateEventListener> listenerList = new LinkedList<>();

    public void add( UpdateEventListener listener) { this.listenerList.add(listener); }

    public void remove(UpdateEventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(UpdateEvent event){ for (UpdateEventListener listener : listenerList) { listener.onIncrementEvent(event); } }
}
