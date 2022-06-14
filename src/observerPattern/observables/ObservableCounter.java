package observerPattern.observables;

import domainLogic.util.Counter;

import java.io.Serializable;
import java.util.Observable;

public class ObservableCounter extends Observable implements Serializable {
    Counter counter = new Counter();

    public Long getCounter() {
        return counter.getCounter();
    }

    public void increment(){
        this.counter.increment();
        this.setChanged();
        this.notifyObservers();
    }
}
