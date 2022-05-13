package eventSystem.listener;

import domainLogic.GLContent;
import domainLogic.GLUploader;
import eventSystem.infrastructure.CreateEvent;
import eventSystem.infrastructure.CreateEventListener;

//TODO: evtl fehler hier
public class CreateEventListenerImpl implements CreateEventListener {

    private GLContent model;

    public CreateEventListenerImpl(GLContent model) {
        this.model = model;
    }

    @Override
    public void onCreateEvent(CreateEvent createEvent) {
        this.model.createContent(createEvent.getContent(), createEvent.getContent().getUploader());
    }
}
