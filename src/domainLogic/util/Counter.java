package domainLogic.util;

import java.util.Observable;

/**
 * Counter for everything that needs a counter starts to count at 0
 * counts +1 if called and returns true
 * starts to count from 0 again if Long.Max_Value is reached (gives message, returns false)
 */
public abstract class Counter extends Observable {

    private long counter = 0;

    public long getCounter() {
        return this.counter;
    }

    public boolean increment(){
        if(this.counter == Long.MAX_VALUE){
            System.out.println("Counter full, start from 0 now");
            this.counter = 0;
            return false;
        }else{
            this.counter += 1;
            return true;
        }
    }
}
