package eventSystem.listener;

import domainLogic.GLContentImpl;
import eventSystem.infrastructure.UpdateSingleAccessCountEvent;
import eventSystem.infrastructure.UpdateSingleAccessCountEventListener;

public class UpdateSingleAccessCountEventListenerImpl implements UpdateSingleAccessCountEventListener {

    GLContentImpl glContentImpl;

    public UpdateSingleAccessCountEventListenerImpl(GLContentImpl glContentImpl) {
        this.glContentImpl = glContentImpl;
    }

    @Override
    public void onIncrementEvent(UpdateSingleAccessCountEvent updateSingleAccessCountEvent) {
            this.glContentImpl.update(updateSingleAccessCountEvent.getAddress());
    }
}
