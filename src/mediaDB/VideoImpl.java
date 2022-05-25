package mediaDB;

import domainLogic.util.Counter;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class VideoImpl implements Video {

    private Counter counter;
    private Uploader uploader;
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
        this.counter.increment();
        return this.counter.getAccessCount();
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
