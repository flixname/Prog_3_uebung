package domainLogic.util;

/**
 * Access Count for files
 * counts 1++ if update() in GLContent is called
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
