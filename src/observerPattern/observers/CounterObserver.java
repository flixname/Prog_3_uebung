package observerPattern.observers;

import observerPattern.observables.ObservableCounter;

import java.util.Observable;
import java.util.Observer;

public class CounterObserver implements Observer {
    private ObservableCounter observableCounter;
    private long oldState;

    public CounterObserver(ObservableCounter observableCounter){
        this.observableCounter = observableCounter;
        this.oldState = this.observableCounter.getCounter().getCounter();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.oldState != this.observableCounter.getCounter().getCounter()){
            System.out.println("value changed from "+this.oldState+" to "+this.observableCounter.getCounter().getCounter());
            this.oldState = this.observableCounter.getCounter().getCounter();
        }
        else {
            System.out.println("no changes");
        }
    }
}
