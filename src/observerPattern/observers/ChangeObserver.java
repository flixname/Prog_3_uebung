package observerPattern.observers;

import eventSystem.model.CounterMemory;

import java.util.Observable;
import java.util.Observer;

public class ChangeObserver implements Observer {

    private CounterMemory counterMemory;

    private int lastValue;
    public ChangeObserver(CounterMemory counterMemory){
        this.counterMemory= counterMemory;
        this.lastValue= this.counterMemory.getValue();
    }
    @Override
    public void update(Observable o, Object arg) {
        if(this.lastValue!= counterMemory.getValue()){
            System.out.println("value changed from "+this.lastValue+" to "+this.counterMemory.getValue());
            this.lastValue= this.counterMemory.getValue();
        }else System.out.println("no changes");
    }
}
