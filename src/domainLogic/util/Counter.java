package domainLogic.util;

/**
 * Access Count for files
 * counts 1++ if update() in GLContent is called
 */
public abstract class Counter {

    private long Counter;

    public Counter() {}

    public long getCounter() { return this.Counter; }

    public void increment(){
        if(Long.MAX_VALUE == Counter){
            System.out.println("AccessCount full, start from 0 now");
            this.Counter = 0;
        }
        this.Counter++;
    }
}
