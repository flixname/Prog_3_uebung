package mediaDB;

import observerPattern.observables.ObservableCounter;

import java.util.Date;

/**
 * choose name or get a default name if not assigned
 */
public class UploaderImpl implements Uploader{

    private String uploaderName;
    private ObservableCounter counter = new ObservableCounter();

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
