package eventSystem.listener;

import domainLogic.GLContentImpl;
import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;

public class UpdateCounterEventListenerImpl implements UpdateCounterEventListener {

    GLContentImpl glContentImpl;

    public UpdateCounterEventListenerImpl(GLContentImpl glContentImpl) {
        this.glContentImpl = glContentImpl;
    }

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
            this.glContentImpl.update(updateCounterEvent.getAddress());
    }
}
