package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class ReadDiverseContentEventHandler {

    private List<ReadDiverseContentEventListener> listenerList = new LinkedList<>();

    public void add(ReadDiverseContentEventListener listener) { this.listenerList.add(listener); }

    public void remove(ReadDiverseContentEventListener listener) { this.listenerList.remove(listener); }

    public void handle(ReadDiverseContentEvent event){ for (ReadDiverseContentEventListener listener : listenerList) listener.onReadEvent(event); }
}
