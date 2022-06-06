package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class UpdateCounterEventHandler {

    private List<UpdateCounterEventListener> updateCounterEventListenerLinkedList = new LinkedList<>();

    public void add( UpdateCounterEventListener updateCounterEventListener) {
        this.updateCounterEventListenerLinkedList.add(updateCounterEventListener);
    }

    public void remove(UpdateCounterEventListener updateCounterEventListener) {
        this.updateCounterEventListenerLinkedList.remove(updateCounterEventListener);
    }

    public void handle(UpdateCounterEvent updateCounterEvent){
        for (UpdateCounterEventListener updateCounterEventListener : updateCounterEventListenerLinkedList) {
            updateCounterEventListener.onUpdateCounterEvent(updateCounterEvent);
        }
    }
}
