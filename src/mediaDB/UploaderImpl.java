package mediaDB;

/**
 * giving Uploaders Names
 */
public class UploaderImpl implements Uploader{

    private String uploaderName;


    public UploaderImpl(String name) {
        this.uploaderName = name;
    }

    public UploaderImpl(){
        this.uploaderName = "default_name";
    }

    @Override
    public String getName() {
        return this.uploaderName;
    }
}
