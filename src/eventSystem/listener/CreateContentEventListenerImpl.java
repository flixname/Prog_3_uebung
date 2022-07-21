package eventSystem.listener;

import domainLogic.Logic;
import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;
import mediaDB.DataImpl;

public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private Logic logic;

    public CreateContentEventListenerImpl(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void onCreateContentEvent(CreateContentEvent createContentEvent) {
        this.logic.createContent(new DataImpl(createContentEvent.getDataType(), createContentEvent.getUploaderName(), createContentEvent.getTagCollection(),
                createContentEvent.getBitrate(), createContentEvent.getLaenge()));
    }
}
