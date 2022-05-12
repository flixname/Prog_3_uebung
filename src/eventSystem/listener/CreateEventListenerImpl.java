package eventSystem.listener;

import domainLogic.GLContent;
import eventSystem.infrastructure.CreateEvent;
import eventSystem.infrastructure.CreateEventListener;

public class CreateEventListenerImpl implements CreateEventListener {

    private GLContent model;

    public CreateEventListenerImpl(GLContent model) {
        this.model = model;
    }

    @Override
    public void onCreateEvent(CreateEvent createEvent) {
        this.model.create(createEvent.getContent());
    }
}
