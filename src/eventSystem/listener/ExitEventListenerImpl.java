package eventSystem.listener;

import eventSystem.infrastructure.ExitEvent;
import eventSystem.infrastructure.ExitEventListener;
import eventSystem.viewControl.MasterConsole;

public class ExitEventListenerImpl implements ExitEventListener {

    @Override
    public void onExitEvent(ExitEvent exitEvent) {
        System.out.println("Exit program.");
        System.exit(0);
    }
}
