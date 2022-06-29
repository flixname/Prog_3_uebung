package domainLogic;

import mediaDB.Uploader;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/**
 * Uploaderverwaltung
 */
public class UploaderLogic implements Serializable {

    private List<Uploader> uploaderLinkedList = new LinkedList();

    public List<Uploader> getUploaderLinkedList() {
        return uploaderLinkedList;
    }

    public void createUploader(Uploader uploader) {
        this.uploaderLinkedList.add(uploader);
    }

    public void deleteUploader(Uploader uploader) {
        this.uploaderLinkedList.remove(uploader);
    }
}
