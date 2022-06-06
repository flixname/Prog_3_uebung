package eventSystem.listener;

import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;

public class UpdateCounterInfoListenerImpl implements UpdateCounterEventListener {

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
        System.out.println("an event was received");
    }
}
