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

    private ObservableAddress observableAddress; //unique address ID
    private ObservableCounter observableCounter = new ObservableCounter(); //AccessCounter


    public AudioImpl(Integer addressCount, String uploader, int bitrate, long laenge, String tags) {
        this.observableAddress = new ObservableAddress(addressCount);
        this.uploader = new UploaderImpl(uploader);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.observableTag = new ObservableTag(tags);
    }


    @Override //TODO
    public int getSamplingRate() {
        return 0;
    }

    @Override
    public String getAddress() {
        return this.observableAddress.getAddress();
    }

    @Override //TODO: BIG TODO... ;(->wie create tag von aussen, liste immer null
    public Collection<Tag> getTags() {
        return this.observableTag.getTagList();
    }

    @Override
    public long getAccessCount() {
        this.observableCounter.increment();
        return this.observableCounter.getCounter();
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
