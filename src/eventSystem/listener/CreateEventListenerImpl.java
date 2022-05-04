package eventSystem.listener;

import domainLogic.Verwaltung;
import eventSystem.infrastructure.CreateEvent;
import eventSystem.infrastructure.CreateEventListener;

public class CreateEventListenerImpl implements CreateEventListener {

    private Verwaltung model;

    public CreateEventListenerImpl(Verwaltung model) {
        this.model = model;
    }

    @Override
    public void onCreateEvent(CreateEvent createEvent) {
        this.model.create(createEvent.getContent());
    }
}
