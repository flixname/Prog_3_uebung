package mediaDB;



import domainLogic.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class AudioImpl implements Audio {

    private ObservableCounter observableCounter;
    private ObservableTag observableTag;

    private Uploader uploader;
    private Address address;
    private Bitrate bitrate;
    private Laenge laenge;


    public AudioImpl(Address address, String uploader, Collection<Tag> tagCollection, BigDecimal bitrate, Duration laenge) {
        this.address = address;
        this.observableTag = new ObservableTag(tagCollection);
        this.bitrate.setBitrate(bitrate);
        this.laenge.setLaenge(laenge);
        this.uploader = new UploaderImpl(uploader);
    }


    @Override //TODO
    public int getSamplingRate() {
        return 0;
    }

    @Override //TODO: siehe A-Blatt
    public String getAddress() {
        return this.address.getAddress();
    }

    @Override //TODO: BIG TODO... ;(->wie create tag von aussen, liste immer null
    public Collection<Tag> getTags() {
        return this.observableTag.getTagCollection();
    }

    @Override
    public long getAccessCount() {
        this.observableCounter.increment();
        return this.observableCounter.getValue();
        /*
        this.increment();
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        return this.getValue();
        */
    }

    @Override
    public BigDecimal getBitrate() {
        return this.bitrate.getBitrate();
    }

    @Override
    public Duration getLength() {
        return this.laenge.getLaenge();
    }

    @Override //TODO
    public BigDecimal getSize() {
        return null;
    }

    @Override
    public Uploader getUploader() {
        return this.uploader;
    }

    @Override //TODO
    public Date getUploadDate() {
        return null;
    }
}
