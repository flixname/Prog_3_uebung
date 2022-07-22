package mediaDB.util;

public abstract class MediaTypeBaseDecorator implements MediaType{

    private MediaType mediaType;

    public MediaTypeBaseDecorator(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String setMediaType() {
        return this.mediaType.setMediaType();
    }
}
