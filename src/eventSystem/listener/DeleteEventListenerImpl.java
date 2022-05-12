package eventSystem.listener;

import domainLogic.GLContent;
import eventSystem.infrastructure.DeleteEvent;
import eventSystem.infrastructure.DeleteEventListener;

public class DeleteEventListenerImpl implements DeleteEventListener {

    private GLContent model;

    public DeleteEventListenerImpl(GLContent model) {
        this.model = model;
    }

    @Override
    public void onDeleteEvent(DeleteEvent deleteEvent) {
        try {
            this.model.delete(deleteEvent.getDataNr());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
