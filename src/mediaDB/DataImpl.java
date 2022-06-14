package mediaDB;


import domainLogic.util.*;
import observerPattern.observables.ObservableAccessCounter;
import observerPattern.observables.ObservableTag;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DataImpl<M extends MediaContent> implements Uploadable, Licensed, AudioVideo{

    private M mediaContent;

    private SamplingRate samplingRate;
    private Uploader uploader;
    private ObservableTag observableTag;
    private Bitrate bitrate;
    private Laenge laenge;
    private Date uploadDate;
    private Address address;
    private ObservableAccessCounter observableAccessCounter;

    public DataImpl(Address address, Date uploadDate, String uploader, String tags, int bitrate, long laenge) {
        this.samplingRate = new SamplingRate();
        this.uploader = new UploaderImpl(uploader);
        this.observableTag = new ObservableTag(tags);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.uploadDate = new Date();
        this.address = new Address(address.getAddress());
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
        return null;
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
        return null;
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
