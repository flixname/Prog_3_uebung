package domainLogic;

import java.util.Observable;

public abstract class ObservableCounter extends Observable {

    private long value;

    public void increment(){
        if(Long.MAX_VALUE==value) return;
        this.value++;
        this.setChanged();
        this.notifyObservers();
    }

    public long getValue() {
        return value;
    }
}
