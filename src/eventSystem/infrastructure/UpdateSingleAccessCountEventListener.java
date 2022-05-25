package eventSystem.infrastructure;

import java.util.EventListener;

public interface UpdateSingleAccessCountEventListener extends EventListener {
    void onIncrementEvent(UpdateSingleAccessCountEvent updateSingleAccessCountEvent);
}