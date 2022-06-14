package eventSystem.listener;

import domainLogic.ContentLogic;
import eventSystem.infrastructure.ReadDiverseContentEvent;
import eventSystem.infrastructure.ReadDiverseContentEventListener;

public class ReadDiverseContentEventListenerImpl implements ReadDiverseContentEventListener {

    ContentLogic contentLogic;

    public ReadDiverseContentEventListenerImpl(ContentLogic contentLogic) {
        this.contentLogic = contentLogic;
    }

    @Override
    public void onReadEvent(ReadDiverseContentEvent readDiverseContentEvent) {
        //this.glContentImpl.readContentByType(readDiverseContentEvent.getType());
    }
}
