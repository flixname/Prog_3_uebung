package eventSystem.listener;

import eventSystem.infrastructure.UpdateEvent;
import eventSystem.infrastructure.UpdateEventListener;

public class UpdateInfoListenerImpl implements UpdateEventListener {

    @Override
    public void onIncrementEvent(UpdateEvent event) {
        System.out.println("an event was received");
    }
}