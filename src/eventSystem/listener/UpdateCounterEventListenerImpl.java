package eventSystem.listener;

import domainLogic.GLContent;
import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;
import observerPattern.observables.ObservableCounter;

public class UpdateCounterEventListenerImpl implements UpdateCounterEventListener {

    private GLContent glContent;

    public UpdateCounterEventListenerImpl(GLContent glContent) {
       this.glContent = glContent;
    }

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
        this.glContent.update(updateCounterEvent.getAddress());
    }
}
