package mediaDB;


import domainLogic.util.*;
import observerPattern.observables.ObservableAddress;
import observerPattern.observables.ObservableCounter;
import observerPattern.observables.ObservableTag;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class AudioImpl implements Audio {



    private Uploader uploader;
    private ObservableTag observableTag;
    private Bitrate bitrate;
    private Laenge laenge;

    private final ObservableAddress observableAddress; //unique address ID
    private ObservableCounter observableCounter = new ObservableCounter(); //AccessCounter


    public AudioImpl(Integer address, String uploader, String tagCollection, int bitrate, long laenge) {
        this.observableAddress = new ObservableAddress(address);
        this.uploader = new UploaderImpl(uploader);
        this.observableTag = new ObservableTag(tagCollection);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
    }


    @Override //TODO
    public int getSamplingRate() {
        return 0;
    }

    @Override //TODO: siehe A-Blatt
    public String getAddress() {
        return this.observableAddress.getAddress();
    }

    @Override //TODO: BIG TODO... ;(->wie create tag von aussen, liste immer null
    public Collection<Tag> getTags() {
        return this.observableTag.getTagCollection();
    }

    @Override
    public long getAccessCount() {
        this.observableCounter.increment();
        return this.observableCounter.getAccessCount();
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
