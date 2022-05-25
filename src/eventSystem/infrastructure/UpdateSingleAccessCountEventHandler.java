package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class UpdateSingleAccessCountEventHandler {

    private List<UpdateSingleAccessCountEventListener> listenerList = new LinkedList<>();

    public void add( UpdateSingleAccessCountEventListener listener) { this.listenerList.add(listener); }

    public void remove(UpdateSingleAccessCountEventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(UpdateSingleAccessCountEvent event){ for (UpdateSingleAccessCountEventListener listener : listenerList) { listener.onIncrementEvent(event); } }
}
