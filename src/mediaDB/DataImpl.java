package mediaDB;


import domainLogic.util.*;
import observerPattern.observables.ObservableAccessCounter;
import observerPattern.observables.ObservableTag;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DataImpl<M extends MediaContent> implements Uploadable, Licensed, AudioVideo, Serializable {

    private M mediaContent;

    private Address address;
    private Uploader uploader;
    private ObservableTag observableTag;
    private Bitrate bitrate;
    private Laenge laenge;
    private SamplingRate samplingRate;
    private Date uploadDate;
    private ObservableAccessCounter observableAccessCounter;

    public DataImpl(Address address, String uploader, String tags, int bitrate, long laenge) {
        this.address = new Address(address.getAddress());
        this.uploader = new UploaderImpl(uploader);
        this.observableTag = new ObservableTag(tags);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.samplingRate = new SamplingRate(); //TODO
        this.uploadDate = new Date();
        this.observableAccessCounter = new ObservableAccessCounter();
    }

    public void update(){
        this.observableAccessCounter.increment();
    }

    @Override
    public int getSamplingRate() {
        return 0;
    }

    @Override
    public String getAddress() {
        return this.address.getAddress();
    }

    @Override
    public Collection<Tag> getTags() {
        /*return this.observableTag.getTagHashMap();*/
        return null; //TODO: Collection
    }

    @Override
    public long getAccessCount() {
        return this.observableAccessCounter.getCounter();
    }

    @Override
    public String getHolder() {
        return null;
    }

    @Override
    public BigDecimal getBitrate() {
        return this.bitrate.getBitrate();
    }

    @Override
    public Duration getLength() {
        return this.laenge.getLaenge();
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
        return this.uploadDate;
    }

    @Override
    public int getResolution() {
        return 0;
    }
}
