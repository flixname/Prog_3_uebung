package eventSystem.listener;

import domainLogic.GLContent;
import eventSystem.infrastructure.CreateEvent;
import eventSystem.infrastructure.CreateContentEventListener;

//TODO: fehler
public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private GLContent glContent;

    public CreateContentEventListenerImpl(GLContent glContent) {
        this.glContent = glContent;
    }

    @Override
    public void onCreateEvent(CreateEvent createEvent) {
        this.glContent.createContent(createEvent.getContent());
    }
}
