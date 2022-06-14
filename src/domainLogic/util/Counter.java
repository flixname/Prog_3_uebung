package domainLogic.util;

import mediaDB.Content;

import java.io.Serializable;
import java.util.Observable;

/**
 * Counter for everything that needs a counter starts to count at 0
 * counts +1 if called and returns true
 * starts to count from 0 again if Long.Max_Value is reached (gives message, returns false)
 */
public class Counter implements Serializable {

    private long startCounter = -1;
    private Long counter = startCounter;

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
