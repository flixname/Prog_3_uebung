package domainLogic.util;

/**
 * Access Count for files
 */
public abstract class Counter {

    private long accessCount;

    public Counter() {}

    public long getAccessCount() { return this.accessCount; }

    public void increment(){
        if(Long.MAX_VALUE == accessCount){
            return;
        }
        this.accessCount++;
    }
}
