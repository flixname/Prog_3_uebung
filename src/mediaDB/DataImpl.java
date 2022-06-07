package mediaDB;


import domainLogic.util.*;
import observerPattern.observables.ObservableAddress;
import observerPattern.observables.ObservableCounter;
import observerPattern.observables.ObservableTag;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DataImpl<C extends Content,U extends Uploadable> implements Data{

    private U uploadable;
    private C content;

    private Uploader uploader;
    private ObservableTag observableTag;
    private Bitrate bitrate;
    private Laenge laenge;

    private ObservableAddress observableAddress; //unique address ID
    private ObservableCounter observableCounter; //AccessCounter

    public DataImpl(C content, Integer generalAddressAssignment, String uploader, String tags, int bitrate, long laenge) {
        this.content = content;
        this.observableAddress = new ObservableAddress(generalAddressAssignment);
        this.uploader = new UploaderImpl(uploader);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.observableTag = new ObservableTag(tags);
        this.observableCounter = new ObservableCounter();
    }
/*
    @Override //TODO
    public int getSamplingRate() {
        return 0;
    }

    @Override
    public String getAddress() {
        this.observableCounter.increment();
        return this.observableAddress.getAddress();
    }

    @Override //TODO: BIG TODO... ;(->wie create tag von aussen, liste immer null
    public Collection<Tag> getTags() {
        return this.observableTag.getTagList();
    }

    @Override
    public long getAccessCount() {
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
    */
}
