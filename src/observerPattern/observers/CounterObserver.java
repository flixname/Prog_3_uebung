package observerPattern.observers;

import observerPattern.observables.ObservableCounter;

import java.util.Observable;
import java.util.Observer;

public class CounterObserver implements Observer {
    private ObservableCounter observableCounter;
    private long oldAccessCount;

    public CounterObserver(ObservableCounter observableCounter) {
        this.observableCounter = observableCounter;
        this.oldAccessCount = this.observableCounter.getCounter();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.oldAccessCount!= observableCounter.getCounter()){
            System.out.println("value changed from "+this.oldAccessCount+" to "+this.observableCounter.getCounter());
            this.oldAccessCount=this.observableCounter.getCounter();
        }else {
            System.out.println("no changes");
        }
    }
}
