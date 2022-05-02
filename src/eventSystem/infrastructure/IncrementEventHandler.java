package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class IncrementEventHandler {

    private List<IncrementEventListener> listenerList = new LinkedList<>();

    public void add( IncrementEventListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(IncrementEventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(IncrementEvent event){
        for (IncrementEventListener listener : listenerList) {
            listener.onIncrementEvent(event);
        }
    }
}
