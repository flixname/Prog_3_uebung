package eventSystem.listener;

import domainLogic.Logic;
import eventSystem.infrastructure.ReadDiverseContentEvent;
import eventSystem.infrastructure.ReadDiverseContentEventListener;

public class ReadDiverseContentEventListenerImpl implements ReadDiverseContentEventListener {

    Logic logic;

    public ReadDiverseContentEventListenerImpl(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void onReadEvent(ReadDiverseContentEvent readDiverseContentEvent) {
        this.logic.readContentByType(readDiverseContentEvent.getType());
    }
}
