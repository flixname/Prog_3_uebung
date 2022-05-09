package mediaDB;

/**
 * giving uploaders Names
 */
public class UploaderImpl implements Uploader{

    private String uploaderName;

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    @Override
    public String getName() {
        if (this.uploaderName != null) {
            return this.uploaderName;
        } else {
            throw new NullPointerException("No name here!");
        }
    }
}
