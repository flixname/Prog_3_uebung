package observerPattern.observables;

import mediaDB.util.Size;

import java.math.BigDecimal;
import java.util.Observable;

public class ObservableMapSize extends Observable {

    private final BigDecimal maxCapacity;
    private Size size;

    public ObservableMapSize(BigDecimal maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Size getSize() {
        return this.size;
    }

    public boolean setSize(long size) { //TODO: Randtest
        if(size > 0 && this.size.getSize().longValue() > 0){
            if(Long.MAX_VALUE - size < this.size.getSize().longValue()){
                return false;
            }
        }else if(size < 0 && this.size.getSize().longValue() < 0) {
            if(Long.MIN_VALUE - size > this.size.getSize().longValue()) {
                return false;
            }
        }else{
            if(maxCapacity.longValue() + size < maxCapacity.longValue())
            this.size = new Size(size);
            this.setChanged();
            this.notifyObservers();
        }
        return true;
    }
}
