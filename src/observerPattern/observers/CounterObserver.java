package observerPattern.observers;

import observerPattern.Observer;
import observerPattern.observables.ObservableCounter;

public class CounterObserver implements Observer {
    private ObservableCounter observableCounter;
    private long oldAccessCount;

    public CounterObserver(ObservableCounter observableCounter) {
        this.observableCounter = observableCounter;
        this.observableCounter.addObserver(this);
        this.oldAccessCount = this.observableCounter.getCounter();
    }

    @Override
    public void update() {
        long newAccessCount = observableCounter.getCounter();
        if(newAccessCount != this.oldAccessCount){
            System.out.println("new AccessCount: " + newAccessCount);
            this.oldAccessCount = newAccessCount;
        }
    }
}
