package mediaDB;

/**
 * giving Uploaders Names
 */
public class UploaderImpl implements Uploader{

    private String uploaderName;

    public UploaderImpl(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    @Override
    public String getName() {
        if (this.uploaderName != null) {
            System.out.println("No name here!");
        }
        return this.uploaderName;


    }
}
