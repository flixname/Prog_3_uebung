package mediaDB;


import domainLogic.util.*;
import observerPattern.observables.ObservableAccessCounter;
import observerPattern.observables.ObservableAddress;
import observerPattern.observables.ObservableTag;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class DataImpl<M extends MediaContent> implements Data{

    private M mediaContent;

    private Uploader uploader;
    private ObservableTag observableTag;
    private Bitrate bitrate;
    private Laenge laenge;
    private Date uploadDate;
    private ObservableAddress observableAddress;
    private ObservableAccessCounter observableAccessCounter;

    public DataImpl(ObservableAddress observableAddress, Date uploadDate, String uploader, String tags, int bitrate, long laenge) {
        this.observableAddress = new ObservableAddress(observableAddress.getAddress());
        this.uploadDate = uploadDate;
        this.uploader = new UploaderImpl(uploader);
        this.bitrate = new Bitrate(bitrate);
        this.laenge = new Laenge(laenge);
        this.observableTag = new ObservableTag(tags);
        this.observableAccessCounter = new ObservableAccessCounter();
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
    public String getName() {
        return null;
    }
}
