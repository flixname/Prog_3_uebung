package domainLogic;

import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Verwaltung für Uploader
 */
public class GLUploaderImpl {

    HashMap<String, Uploader> uploaderHashMap = new HashMap<>();

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * TODO: Anlegen von Produzenten; dabei muss sichergestellt sein, dass kein Name mehr als einmal vorkommt
     * creates an uploader (Anlegen von Produzenten)
     * @param name ein name
     */
    public void createUploader(String name) {
        Uploader uploader = new UploaderImpl(name);
        if(this.uploaderHashMap.containsKey(name)){
            System.out.println("Uploader vergeben");
        }
        this.uploaderHashMap.put(name, uploader);
    }

    /**
     * TODO: Abruf aller Produzenten mit der Anzahl der ihrer Mediadateien
     * @return liefert gesamte DB LinkedList
     */
    public LinkedList<Uploader> readUplaoder() {
        return null;
    }

    /**
     * TODO: Löschen eines bestimmten Produzenten(Uploader)
     * @param dataNr Nummer der zu löschenden Datei in DB ArrayList
     */
    public void delete(Integer dataNr) {

    }
}
