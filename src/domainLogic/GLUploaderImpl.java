package domainLogic;

import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.HashMap;
import java.util.LinkedList;

public class GLUploaderImpl implements GLUploader{

    HashMap<String, Uploader> uploaderHashMap = new HashMap<>();

    @Override
    public void createUploader(String name) {
        Uploader uploader = new UploaderImpl(name);
        if(this.uploaderHashMap.containsKey(name)){
            System.out.println("Uploader vergeben");
        }
        this.uploaderHashMap.put(name, uploader);
    }

    @Override
    public LinkedList<Uploader> readUplaoder() {
        return null;
    }

    @Override
    public void delete(Integer dataNr) {

    }
}
