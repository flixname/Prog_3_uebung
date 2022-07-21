package mediaDB;


import mediaDB.util.*;
import mediaDB.util.AccessCounter;
import mediaDB.util.Tags;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DataImpl implements AudioVideo, Licensed, Serializable {

    private Address address;
    private UploaderImpl uploader;
    private Tags tags;
    private Bitrate bitrate;
    private Laenge laenge;
    private SamplingRate samplingRate;
    private Date uploadDate;
    private AccessCounter accessCounter;
    private Size size;
    //private final Resolution resolution; TODO
    private MediaType mediaType;

    public DataImpl() {
    }

    public DataImpl(String mediaType, String uploader, String tags, int bitrate, long laenge) {
        this.uploader.setNAME(uploader);
        this.tags = new Tags(tags);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.samplingRate = new SamplingRate(); //TODO
        this.uploadDate = new Date();
        this.accessCounter = new AccessCounter();
        this.mediaType = new MediaType(mediaType);
        this.size = new Size(bitrate + laenge);
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void giveDataAnAddress(Long address){
        this.address = new Address(address);
    }

    public void update(){
        this.accessCounter.increment();
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
        return this.accessCounter.getCounter();
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
        return BigDecimal.valueOf(this.size.getSize());
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
