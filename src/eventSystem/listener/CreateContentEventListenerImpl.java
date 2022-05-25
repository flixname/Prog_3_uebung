package eventSystem.listener;

import domainLogic.GLContentImpl;
import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;

//TODO: fehler
public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private GLContentImpl glContentImpl;

    public CreateContentEventListenerImpl(GLContentImpl glContentImpl) {
        this.glContentImpl = glContentImpl;
    }

    @Override
    public void onCreateEvent(CreateContentEvent createContentEvent) {
        this.glContentImpl.createContent(createContentEvent.getDataType(), createContentEvent.getUploaderName(), createContentEvent.getTagCollection(), createContentEvent.getBitrate(), createContentEvent.getLaenge());
    }
}
