package observerPattern.observables;

import domainLogic.util.Counter;

public class ObservableCounter extends Counter {

    //starts at -1 get incremented when instantiated
    public ObservableCounter() {
        super();
        this.increment();
        this.setChanged();
        this.notifyObservers();
    }
}
