package mediaDB;


import mediaDB.util.*;
import observerPattern.observables.ObservableAccessCounter;
import observerPattern.observables.ObservableTag;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DataImpl implements AudioVideo, Licensed, Serializable {

    private Address address;
    private Uploader uploader;
    private ObservableTag observableTag;
    private final Bitrate bitrate;
    private final Laenge laenge;
    private final SamplingRate samplingRate;
    private final Date uploadDate;
    private final ObservableAccessCounter observableAccessCounter;
    private final Size size;
    //private final Resolution resolution; TODO
    private final MediaType mediaType;

    public DataImpl(String mediaType, String uploader, String tags, int bitrate, long laenge) {
        this.uploader = new UploaderImpl(uploader);
        this.observableTag = new ObservableTag(tags);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.samplingRate = new SamplingRate(); //TODO
        this.uploadDate = new Date();
        this.observableAccessCounter = new ObservableAccessCounter();
        this.mediaType = new MediaType(mediaType);
        this.size = new Size(bitrate + laenge); //fue ObservableMapSize
    }

    public void giveAddress(Long address){
        this.address = new Address(address);
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
        return this.size.getSize();
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
