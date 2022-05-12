package mediaDB;

import domainLogic.ObservableCounter;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class AudioWithCounterImpl implements Audio {

    private ObservableCounter observableCounter;
    private Uploader uploader = new UploaderImpl();
    private Collection<Tag> tagCollection;

    @Override
    public int getSamplingRate() {
        return 0;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public Collection<Tag> getTags() {
        return this.tagCollection;
    }

    @Override
    public long getAccessCount() {
        this.observableCounter.increment();
        return this.observableCounter.getValue();
    }

    @Override
    public BigDecimal getBitrate() {
        return null;
    }

    @Override
    public Duration getLength() {
        return null;
    }

    @Override
    public BigDecimal getSize() {
        return null;
    }

    @Override
    public Uploader getUploader() {
        return this.uploader;
    }

    @Override
    public Date getUploadDate() {
        return null;
    }
}
