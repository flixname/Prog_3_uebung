package domainLogic.util;

import mediaDB.Content;

import java.util.Observable;

/**
 * Counter for everything that needs a counter starts to count at 0
 * counts +1 if called and returns true
 * starts to count from 0 again if Long.Max_Value is reached (gives message, returns false)
 */
public abstract class Counter extends Observable {

    private long startCounter = -1;
    private Long counter = startCounter;

    public long getCounter() {
        return this.counter;
    }

    public Long increment(){
        if(this.counter == Long.MAX_VALUE){
            System.out.println("Counter full, start from 0 now");
            long newCounter = 0;
            this.counter = newCounter;
        }else{
            long newCounter = +1;
            this.counter = newCounter;
        }
        return this.counter;
    }
}
