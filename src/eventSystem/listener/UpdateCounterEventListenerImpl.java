package eventSystem.listener;

import domainLogic.IContentGL;
import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;

public class UpdateCounterEventListenerImpl implements UpdateCounterEventListener {

    private IContentGL iContentGL;

    public UpdateCounterEventListenerImpl(IContentGL iContentGL) {
       this.iContentGL = iContentGL;
    }

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
        this.iContentGL.update(updateCounterEvent.getAddress());
    }
}
