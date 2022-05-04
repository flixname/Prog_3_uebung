package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class ExitEventHandler {
    private List<ExitEventListener> listenerList = new LinkedList<>();

    public void add( ExitEventListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(ExitEventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(ExitEvent event){
        for (ExitEventListener listener : listenerList) {
            listener.onExitEvent(event);
        }
    }
}
