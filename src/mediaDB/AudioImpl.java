package mediaDB;

import eventSystem.util.ObservableCounter;
import eventSystem.util.ObservableTag;
import eventSystem.util.Address;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class AudioImpl implements Audio {

    @Override
    public int getSamplingRate() {
        return 0;
    }

    @Override //TODO: siehe A-Blatt
    public String getAddress() {
        return this.getAddress();
    }

    @Override //TODO: BIG TODO... ;(->wie create tag von aussen, liste immer null
    public Collection<Tag> getTags() {
        return this.getTagCollection();
    }

    @Override
    public long getAccessCount() {
        this.increment();
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        return this.getValue();
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
