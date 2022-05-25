package eventSystem.listener;

import eventSystem.infrastructure.UpdateSingleAccessCountEvent;
import eventSystem.infrastructure.UpdateSingleAccessCountEventListener;

public class UpdateSingleAccessCountInfoListenerImpl implements UpdateSingleAccessCountEventListener {

    @Override
    public void onIncrementEvent(UpdateSingleAccessCountEvent updateSingleAccessCountEvent) {
        System.out.println("an event was received");
    }
}
