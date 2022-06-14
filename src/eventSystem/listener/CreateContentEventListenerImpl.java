package eventSystem.listener;

import domainLogic.ContentLogic;
import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;

public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private ContentLogic contentLogic;

    public CreateContentEventListenerImpl(ContentLogic contentLogic) {
        this.contentLogic = contentLogic;
    }

    @Override
    public void onCreateContentEvent(CreateContentEvent createContentEvent) {
        this.contentLogic.createContent(
                createContentEvent.getDataType(),
                createContentEvent.getUploaderName(),
                createContentEvent.getTagCollection(),
                createContentEvent.getBitrate(),
                createContentEvent.getLaenge()
        );
    }
}
