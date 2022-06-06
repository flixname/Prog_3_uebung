package domainLogic;

import mediaDB.Uploader;
import mediaDB.UploaderImpl;

public class CreateCommand {

    Uploader uploader = new UploaderImpl();


    public CreateCommand(String uploader) {

    }

    public CreateCommand(String contentType, String uploaderName, String tagCollection, int bitrate, long laenge) {

    }
}
