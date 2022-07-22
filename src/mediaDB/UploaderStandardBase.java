package mediaDB;

public class UploaderStandardBase extends UploaderBaseDecorator {

    public UploaderStandardBase(Uploader UPLOADER) {
        super(UPLOADER);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
