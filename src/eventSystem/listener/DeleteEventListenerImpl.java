package eventSystem.listener;

import domainLogic.Verwaltung;
import eventSystem.infrastructure.DeleteEvent;
import eventSystem.infrastructure.DeleteEventListener;
import mediaDB.Content;

public class DeleteEventListenerImpl implements DeleteEventListener {

    private Verwaltung model;

    public DeleteEventListenerImpl(Verwaltung model) {
        this.model = model;
    }

    @Override
    public void onDeleteEvent(DeleteEvent deleteEvent) {
        this.model.delete(deleteEvent.getDataNr());
    }
}
