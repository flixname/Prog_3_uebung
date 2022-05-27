package eventSystem.infrastructure;

import mediaDB.Tag;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.EventObject;

public class CreateContentEvent extends EventObject {

    private String dataType;
    private String uploaderName;
    private int bitrate;
    private long laenge;
    private Collection<String> tagCollection;

    public CreateContentEvent(Object source, String dataType, String uploaderName, int bitrate, long laenge, Collection<String> tagCollection) {
        super(source);
        this.dataType = dataType;
        this.uploaderName = uploaderName;
        this.tagCollection = tagCollection;
        this.bitrate = bitrate;
        this.laenge = laenge;
    }

    public String getDataType() {
        return dataType;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public int getBitrate() {
        return bitrate;
    }

    public long getLaenge() {
        return laenge;
    }

    public Collection<String> getTagCollection() {
        return tagCollection;
    }
}
