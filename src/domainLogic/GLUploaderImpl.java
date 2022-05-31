package domainLogic;

import domainLogic.util.Counter;
import mediaDB.Content;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Verwaltung für Uploader //evl eine main gl die diese beiden als interface implementiert?
 */
public class GLUploaderImpl {

    private static GLContentImpl glContent;

    private static HashMap<Uploader, LinkedList<Content>> uploaderLinkedList = new HashMap<>();

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * creates an uploader (Anlegen von Produzenten), schaut auch ob produzent schon vergeben und legt einen uplaoer mit leerer content liste an
     * @param name ein name
     */
    public boolean createUploader(String name) {
        Uploader uploader = new UploaderImpl(name);
        if(this.uploaderLinkedList.containsKey(uploader.getName())) {
            return false;
        }else{
        this.uploaderLinkedList.put(uploader, new LinkedList<Content>());//TODO: bernehmen in GL und bei de verbinden
            return true;
        }
    }

    /**
     *
     * @return liefert alle produzenten mit der Anzahl ihrer Contents
     */
    public HashMap<Uploader, Integer> readUploader() {
        HashMap<Uploader, Integer> uploaderIntegerHashMap = new HashMap<>();

        for (HashMap.Entry<Uploader, LinkedList<Content>> set :
                this.uploaderLinkedList.entrySet()) {
            uploaderIntegerHashMap.put(set.getKey(), set.getValue().size());
        }
        return uploaderIntegerHashMap;
    }

    /**
     * löscht einen uplaoder ...TODO: und dann??? was passiert mit den files?
     * @param name just the uploadername to be deleted
     */
    public boolean delete(String name) {
        Uploader uploader = new UploaderImpl(name);
        if (this.uploaderLinkedList.containsKey(uploader.getName())) {
            this.uploaderLinkedList.remove(uploader.getName());
            return true;
        }
       return false;
    }
}
