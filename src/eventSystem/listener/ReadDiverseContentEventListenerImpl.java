package eventSystem.listener;

import domainLogic.GLContentImpl;
import eventSystem.infrastructure.ReadDiverseContentEvent;
import eventSystem.infrastructure.ReadDiverseContentEventListener;

public class ReadDiverseContentEventListenerImpl implements ReadDiverseContentEventListener {

    GLContentImpl glContentImpl;

    public ReadDiverseContentEventListenerImpl(GLContentImpl glContentImpl) {
        this.glContentImpl = glContentImpl;
    }

    @Override
    public void onReadEvent(ReadDiverseContentEvent readDiverseContentEvent) {
        this.glContentImpl.readByContentType(readDiverseContentEvent.getType());
    }
}
