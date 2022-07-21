package mediaDB.util;

import java.io.Serializable;

public class MediaType implements Serializable {

    private String mediaType;

    public String getMediaType() {
        return mediaType;
    }

    public MediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
