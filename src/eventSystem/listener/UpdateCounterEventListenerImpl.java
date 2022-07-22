package eventSystem.listener;

import domainLogic.Logic;
import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;

public class UpdateCounterEventListenerImpl implements UpdateCounterEventListener {

    private Logic logic;

    public UpdateCounterEventListenerImpl(Logic logic) {
       this.logic = logic;
    }

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
        this.logic.update(updateCounterEvent.getAddress());
    }
}
