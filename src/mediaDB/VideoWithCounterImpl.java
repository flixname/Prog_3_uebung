package mediaDB;

import domainLogic.ObservableCounter;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class VideoWithCounterImpl implements Video {

    private ObservableCounter observableCounter;
    private Uploader uploader = new UploaderImpl();
    private Collection<Tag> tagCollection;

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public Collection<Tag> getTags() {
        return null;
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

    @Override
    public int getResolution() {
        return 0;
    }
}
