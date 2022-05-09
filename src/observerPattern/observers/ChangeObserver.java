package observerPattern.observers;

import domainLogic.ObservableCounter;

import java.util.Observable;
import java.util.Observer;

public class ChangeObserver implements Observer {

    private ObservableCounter observableCounter;
    private long lastValue;

    public ChangeObserver(ObservableCounter observableCounter, long lastValue) {
        this.observableCounter = observableCounter;
        this.lastValue = lastValue;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.lastValue!= observableCounter.getValue()){
            System.out.println("value changed from "+this.lastValue+" to "+this.observableCounter.getValue());
            this.lastValue= this.observableCounter.getValue();
        }else System.out.println("no changes");
    }
}
