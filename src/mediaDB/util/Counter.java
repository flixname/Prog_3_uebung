package mediaDB.util;

import java.io.Serializable;

/**
 * Counter for everything that needs a counter starts to count at 0
 * counts +1 if called and returns true
 * starts to count from 0 again if Long.Max_Value is reached (gives message, returns false)
 */
public abstract class Counter implements Serializable {

    private long noInitCounter = -1;
    private Long counter = noInitCounter;

    public Long getCounter() {
        return counter;
    }

    public void increment(){
        if(this.counter == Long.MAX_VALUE){
            System.out.println("Counter full, start from 0 now");
            long newCounter = 0;
            this.counter = newCounter;
        }else{
            this.counter++;
        }
    }
}
