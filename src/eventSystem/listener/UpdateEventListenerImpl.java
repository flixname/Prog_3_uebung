package eventSystem.listener;

import domainLogic.GLContent;
import eventSystem.infrastructure.UpdateEvent;
import eventSystem.infrastructure.UpdateEventListener;

public class UpdateEventListenerImpl implements UpdateEventListener {

    GLContent model;

    public UpdateEventListenerImpl(GLContent model) {
        this.model = model;
    }

    @Override
    public void onIncrementEvent(UpdateEvent updateEvent) {
            this.model.update(updateEvent.getDataNr());
    }
}
