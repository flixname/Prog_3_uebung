package eventSystem.listener;

import eventSystem.infrastructure.IncrementEvent;
import eventSystem.infrastructure.IncrementEventListener;
import eventSystem.model.CounterMemory;

public class IncrementEventListenerImpl implements IncrementEventListener {

    private CounterMemory model;

    public IncrementEventListenerImpl(CounterMemory model) {
        this.model=model;
    }

    @Override
    public void onIncrementEvent(IncrementEvent incrementEvent) {
        this.model.getValue();
    }
}
