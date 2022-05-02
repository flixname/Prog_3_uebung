package eventSystem.listener;

import eventSystem.infrastructure.ExitEvent;
import eventSystem.infrastructure.ExitEventListener;

public class ExitEventListenerImpl implements ExitEventListener {

    @Override
    public void onExitEvent(ExitEvent exitEvent) {
        System.out.println("Exit program.");
        System.exit(0);
    }
}
