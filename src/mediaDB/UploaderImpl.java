package mediaDB;

import domainLogic.util.Counter;
import observerPattern.observables.ObservableCounter;

import java.util.Date;

/**
 * giving Uploaders Names
 */
public class UploaderImpl implements Uploader{

    private String uploaderName;
    private ObservableCounter counter; //TODO: Counter als Interface

    public UploaderImpl(String name) {
        this.uploaderName = name;
    }

    public UploaderImpl(){
        this.counter.increment();
        this.uploaderName = "default_name-" + this.counter.getCounter();
    }

    @Override
    public String getName() {
        return this.uploaderName;
    }
}
