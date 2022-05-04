package eventSystem.listener;

import domainLogic.Verwaltung;
import eventSystem.infrastructure.UpdateEvent;
import eventSystem.infrastructure.UpdateEventListener;

public class UpdateEventListenerImpl implements UpdateEventListener {

    Verwaltung model;

    public UpdateEventListenerImpl(Verwaltung model) {
        this.model = model;
    }

    @Override
    public void onIncrementEvent(UpdateEvent updateEvent) {
        this.model.update(updateEvent.getDataNr());
    }
}
