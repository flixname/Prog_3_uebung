package mediaDB;

public abstract class UploaderBaseDecorator implements Uploader {

    private final Uploader UPLOADER;

    public UploaderBaseDecorator(Uploader UPLOADER) {
        this.UPLOADER = UPLOADER;
    }

    @Override
    public String getName() {
        return UPLOADER.getName();
    }
}
