package eventSystem.infrastructure;

import java.util.EventListener;

public interface UpdateCounterEventListener extends EventListener {
    void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent);
}