package domainLogic;

import mediaDB.DataImpl;
import mediaDB.UploaderImpl;

import java.util.Observable;

//Soll die Klasse Logic "abschiermen" um nur strings verwenden zu koennen in den parametern
public class MainLogic extends Observable {

    static final long serialVersionUID=1L;

    private Logic logic = null;

    public MainLogic(long size) {
        this.logic = new Logic(size);
    }

    public boolean createUploader(String name){
        if(this.logic != null){
            UploaderImpl uploader = new UploaderImpl();
            uploader.setNAME(name);
            this.logic.createUploader(uploader);
            return true;
        }else{
            return false;
        }
    }

    /*------------------------
    -------CrEaTe-------------
    ------------------------*/
    public boolean createContent(String mediaType, String uploaderName, String tags, int bitrate, long laenge) {
        if(this.logic != null){
            DataImpl data = new DataImpl(mediaType, uploaderName, tags, bitrate, laenge);
            return this.logic.createContent(data);
        }else{
            return false;
        }
    }

    /*------------------------
    -------UpDaTe-------------
    ------------------------*/
    public boolean update(String address){
            return this.logic.update(address);
    }

}
