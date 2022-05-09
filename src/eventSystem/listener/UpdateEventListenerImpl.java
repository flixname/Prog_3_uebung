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
        try {
            this.model.update(updateEvent.getDataNr()); //gibt es bei remove keine nullpointerexeption oder so???
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
