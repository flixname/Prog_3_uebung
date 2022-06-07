package observerPattern.observables;

import domainLogic.util.Counter;

public class ObservableCounter extends Counter {

    public ObservableCounter() {
        super();
        this.increment();
        this.setChanged();
        this.notifyObservers();
    }
}
