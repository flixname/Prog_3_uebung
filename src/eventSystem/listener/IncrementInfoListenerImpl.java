package eventSystem.listener;

import eventSystem.infrastructure.IncrementEvent;
import eventSystem.infrastructure.IncrementEventListener;

public class IncrementInfoListenerImpl implements IncrementEventListener {

    @Override
    public void onIncrementEvent(IncrementEvent event) {
        System.out.println("an event was received");
    }
}
