package domainLogic.util;

/**
 * Access Count for files
 * counts 1++ if update() in GLContent is called
 */
public abstract class Counter {

    private long counter;

    public Counter() {}

    public long getCounter() { return this.counter; }

    public void increment(){
        if(this.counter == Long.MAX_VALUE){
            System.out.println("AccessCount full, start from 0 now");
            this.counter = 0;
        }
        this.counter++;
    }
}
