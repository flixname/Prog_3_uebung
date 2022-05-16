package eventSystem.util;

import java.util.Observable;

/**
 * Access Count for files
 */
public abstract class ObservableCounter extends Observable {

    private long value;

    public long getValue() { return value; }

    public void increment(){
        if(Long.MAX_VALUE==value) return;
        this.value++;
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
    }
}
