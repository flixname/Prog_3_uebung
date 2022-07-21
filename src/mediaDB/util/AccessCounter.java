package mediaDB.util;

public class AccessCounter extends Counter {
    public AccessCounter() {
        super();
        this.increment();
    }

    public String getStringValue(){
        return this.getCounter().toString();
    }
}
