package eventSystem.listener;

import domainLogic.MainLogic;
import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;

public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private MainLogic mainLogic;

    public CreateContentEventListenerImpl(MainLogic contentLogic) {
        this.mainLogic = mainLogic;
    }

    @Override
    public void onCreateContentEvent(CreateContentEvent createContentEvent) {
        this.mainLogic.createContent(
                createContentEvent.getDataType(),
                createContentEvent.getUploaderName(),
                createContentEvent.getTagCollection(),
                createContentEvent.getBitrate(),
                createContentEvent.getLaenge()
        );
    }
}
