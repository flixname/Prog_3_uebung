package eventSystem.model;

import java.util.Observable;

public class CounterMemoryImpl extends Observable implements CounterMemory {

    private int value;

    public void increment(){
        if(Integer.MAX_VALUE==value) return;
        this.value++;
        this.setChanged();
        this.notifyObservers();
    }

    public int getValue() { return value; }
}
