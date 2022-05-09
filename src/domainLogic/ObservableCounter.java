package domainLogic;
/**
 * Access Count for files
 */
public abstract class ObservableCounter {

    private long value=0;

    public long getValue() { return value; }

    public void increment(){
        if(Long.MAX_VALUE==value) return;
        this.value++;
        /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }
}
