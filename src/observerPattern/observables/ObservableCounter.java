package observerPattern.observables;

import domainLogic.GLContentImpl;
import domainLogic.util.Counter;
import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventListener;


public class ObservableCounter extends Counter implements UpdateCounterEventListener {

    public ObservableCounter() {
        super();
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void onUpdateCounterEvent(UpdateCounterEvent updateCounterEvent) {
        this.increment();
    }
}
