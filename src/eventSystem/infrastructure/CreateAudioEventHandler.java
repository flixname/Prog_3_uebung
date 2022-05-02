package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class CreateAudioEventHandler {

    private List<CreateAudioEventListener> listenerList = new LinkedList<>();

    public void add(CreateAudioEventListener listener) { this.listenerList.add(listener); }

    public void remove(CreateAudioEventListener listener) { this.listenerList.remove(listener); }

    public void handle(CreateAudioEvent event){ for (CreateAudioEventListener listener : listenerList) listener.onCreateEvent(event); }

}
