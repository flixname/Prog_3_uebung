package mediaDB;

import observerPattern.observables.ObservableCounter;

import java.util.Date;

/**
 * choose name or get a default name if not assigned
 */
public class UploaderImpl implements Uploader{

    private final String UPLOADERNAME;

    public UploaderImpl(String name) {
        this.UPLOADERNAME = name;
    }

    @Override
    public String getName() {
        return this.UPLOADERNAME;
    }
}
