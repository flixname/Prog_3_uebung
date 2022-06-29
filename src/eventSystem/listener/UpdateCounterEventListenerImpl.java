package eventSystem.listener;

import domainLogic.ContentLogic;
import domainLogic.MainLogic;
import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;

public class UpdateCounterEventListenerImpl implements UpdateCounterEventListener {

    private MainLogic mainLogic;

    public UpdateCounterEventListenerImpl(MainLogic mainLogic) {
       this.mainLogic = mainLogic;
    }

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
        this.mainLogic.update(updateCounterEvent.getAddress());
    }
}
