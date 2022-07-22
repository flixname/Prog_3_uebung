package mediaDB.util;

public class MediaTypeAudio extends MediaTypeBaseDecorator{

    public MediaTypeAudio(MediaType mediaType) {
        super(mediaType);
    }

    public String setMediaType() {
        return super.setMediaType();
    }

    private String decorateWithAudio() {
        return "audio";
    }
}
