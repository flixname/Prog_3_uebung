package eventSystem.listener;

import domainLogic.GLContent;
import eventSystem.infrastructure.ReadEvent;
import eventSystem.infrastructure.ReadEventListener;

public class ReadEventListenerImpl implements ReadEventListener {

    GLContent model;

    public ReadEventListenerImpl(GLContent model) {
        this.model = model;
    }

    @Override
    public void onReadEvent(ReadEvent readEvent) {
        this.model.readByContentType(readEvent.getTyp());
    }
}
