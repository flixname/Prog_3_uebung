package eventSystem.listener;

import domainLogic.GLContentImpl;
import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;

public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private GLContentImpl glContentImpl;

    public CreateContentEventListenerImpl(GLContentImpl glContentImpl) {
        this.glContentImpl = glContentImpl;
    }

    @Override
    public void onCreateContentEvent(CreateContentEvent createContentEvent) {
        this.glContentImpl.createContent(
                createContentEvent.getDataType(),
                createContentEvent.getUploaderName(),
                createContentEvent.getTagCollection(),
                createContentEvent.getBitrate(),
                createContentEvent.getLaenge()
        );
    }
}
