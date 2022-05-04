package eventSystem.listener;

import domainLogic.Verwaltung;
import eventSystem.infrastructure.IncrementEvent;
import eventSystem.infrastructure.IncrementEventListener;
import eventSystem.model.CounterMemory;

public class IncrementEventListenerImpl implements IncrementEventListener {

    Verwaltung model;

    public IncrementEventListenerImpl(Verwaltung model) {
        this.model = model;
    }

    @Override
    public void onIncrementEvent(IncrementEvent incrementEvent) {
        this.model.update(incrementEvent.getDataNr());
    }
}
