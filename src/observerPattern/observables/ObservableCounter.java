package observerPattern.observables;

import domainLogic.util.Counter;

import java.util.Observable;

public class ObservableCounter extends Observable {
    Counter counter = new Counter();

    public Counter getCounter() {
        return counter;
    }

    public void increment(){
        this.counter.increment();
        this.setChanged();
        this.notifyObservers();
    }
}
