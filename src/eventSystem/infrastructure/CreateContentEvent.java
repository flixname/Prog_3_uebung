package eventSystem.infrastructure;

import java.util.EventObject;

public class CreateContentEvent extends EventObject {

    private String dataType;
    private String uploaderName;
    private String tagCollection;
    private int bitrate;
    private long laenge;


    public CreateContentEvent(Object source, String dataType, String uploaderName, String tagCollection, int bitrate, long laenge) {
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

    public String getTagCollection() {
        return tagCollection;
    }

    public int getBitrate() {
        return bitrate;
    }

    public long getLaenge() {
        return laenge;
    }


}
