package domainLogic;

import java.util.Observable;

/**
 * Access Count for files
 */
public class ObservableCounter extends Observable {

    private long value;

    public ObservableCounter(long value) { this.value = value; }
    public ObservableCounter(){ this.value = 0; }

    public long getValue() { return value; }

    public void increment(){
        if(Long.MAX_VALUE==value){
            return;
        }
        this.value++;
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
    }
}
