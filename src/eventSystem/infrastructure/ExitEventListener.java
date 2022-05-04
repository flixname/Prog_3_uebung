package eventSystem.infrastructure;

import java.util.EventListener;

public interface ExitEventListener extends EventListener {
    void onExitEvent(ExitEvent exitEvent);
}
