package domainLogic;

import domainLogic.util.Counter;
import mediaDB.DataImpl;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Hauptverwaltung
 * Zunaechst soll Uploader erstellt werden dann Mediafile
 */
public class UploaderLogic implements Serializable {

    private ContentLogic contentLogic = new ContentLogic();

    private LinkedList<Uploader> uploaderLinkedList = new LinkedList();

    /**
     * creates an uploader (Anlegen von Produzenten), schaut auch ob produzent schon vergeben irgendwo und legt einen neuen uploader in der uploaderListe an
     * @param name der zu erstellende Name
     */
    public void createUploader(String name) {
        Uploader uploader = new UploaderImpl(name);
        if(this.contentLogic.getAddressMediaContentHashMap().size() == 0){
            this.uploaderLinkedList.add(uploader);
        }else{
            for (Map.Entry<String, DataImpl> entry : this.contentLogic.getAddressMediaContentHashMap().entrySet()) {
                if (entry.getValue().getUploader().getName().equals(name)) {
                    this.uploaderLinkedList.add(uploader);
                }
            }
        }
    }

    /**
     * @return liefert alle produzenten mit der Anzahl(Zahl) ihrer Contents
     */
    public HashMap<Uploader, Long> readUploader() {
        HashMap<Uploader, Long> uploaderIntegerHashMap = new HashMap<>();
        Counter counter = new Counter(); counter.increment();
        for (Uploader listElement : this.uploaderLinkedList) {
            for (HashMap.Entry<String, DataImpl> entry : this.contentLogic.getAddressMediaContentHashMap().entrySet()) {
                if (entry.getValue().getUploader().equals(listElement.getName())) {
                    counter.increment();
                }
            }
            uploaderIntegerHashMap.put(listElement, counter.getCounter());
        }
        return uploaderIntegerHashMap;
    }

    /**
     * Löscht einen Uploader, Files bleiben in der addressMediaContentHashMap bestehen
     * @param name the uploader name to be deleted
     */
    public boolean deleteUploader(String name){
        Uploader uploader = new UploaderImpl(name);
        for (Uploader listElement : this.uploaderLinkedList) {
            if (listElement.getName().equals(uploader.getName())) {
                this.uploaderLinkedList.remove(listElement);
                return true;
            }
        }
        return false;
    }

    public ContentLogic getContentLogic() {
        return contentLogic;
    }

    public void setContentLogic(ContentLogic contentLogic) {
        this.contentLogic = contentLogic;
    }

    public LinkedList<Uploader> getUploaderLinkedList() {
        return uploaderLinkedList;
    }

    public void setUploaderLinkedList(LinkedList<Uploader> uploaderLinkedList) {
        this.uploaderLinkedList = uploaderLinkedList;
    }
}
