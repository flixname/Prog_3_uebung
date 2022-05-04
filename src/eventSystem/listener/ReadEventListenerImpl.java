package eventSystem.listener;

import domainLogic.Verwaltung;
import eventSystem.infrastructure.ReadEvent;
import eventSystem.infrastructure.ReadEventListener;

public class ReadEventListenerImpl implements ReadEventListener {

    Verwaltung model;

    public ReadEventListenerImpl(Verwaltung model) {
        this.model = model;
    }

    @Override
    public void onReadEvent(ReadEvent readEvent) {
        this.model.read();
    }
}
