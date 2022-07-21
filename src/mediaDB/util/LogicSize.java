package mediaDB.util;

import java.io.Serializable;
import java.math.BigDecimal;

public class LogicSize implements Serializable {

    private long maxCapacity;
    private Size actualSize = new Size();

    public void setActualSize(Size actualSize) {
        this.actualSize = actualSize;
    }

    public boolean setMaxCapacity(long maxCapacity) {
        if(maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
            return true;
        }else{
            return false;
        }
    }

    public Size getActualSize() {
        return this.actualSize;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    public boolean setActualSize(long newActualSize) { //TODO: Randtest
        if(newActualSize >= 0 && this.maxCapacity > 0) {
            if (Long.MAX_VALUE - newActualSize < this.actualSize.getSize()) {
                return false;
            }
            /*
        }else if(newActualSize < 0 && this.actualSize.getSize().longValue() < 0) {
            if(Long.MIN_VALUE - newActualSize > this.actualSize.getSize().longValue()) {
                return false;
            }

             */

            if (this.actualSize.getSize() + newActualSize < maxCapacity) {
                this.actualSize = new Size(this.actualSize.getSize() + newActualSize);
                return true;
            }
            return false;
        }
        return false;
    }
}
