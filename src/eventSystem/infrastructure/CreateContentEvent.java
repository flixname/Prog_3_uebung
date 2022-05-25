package eventSystem.infrastructure;

import mediaDB.Tag;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.EventObject;

public class CreateContentEvent extends EventObject {

    String dataType;
    String uploaderName;
    Collection<Tag> tagCollection;
    BigDecimal bitrate;
    Duration laenge;

    public CreateContentEvent(Object source, String dataType, String uploaderName, Collection<Tag> tagCollection, BigDecimal bitrate, Duration laenge) {
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

    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public BigDecimal getBitrate() {
        return bitrate;
    }

    public Duration getLaenge() {
        return laenge;
    }
}
