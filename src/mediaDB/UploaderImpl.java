package mediaDB;

/**
 * giving Uploaders Names
 */
public class UploaderImpl implements Uploader{

    private String uploaderName;

    public UploaderImpl(String uploaderName) {
        this.uploaderName = uploaderName;
    }
    public UploaderImpl(){ this.uploaderName = "default"; }

    @Override
    public String getName() {
        if (this.uploaderName != null) { //aufpassen evtl. immer null?
            System.out.println("No name here!");
        }
        return this.uploaderName;
    }
}
