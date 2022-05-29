package domainLogic;

import domainLogic.util.Counter;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Verwaltung für Uploader
 */
public class GLUploaderImpl {

    LinkedList<Uploader> uploaderLinkedList = new LinkedList<>();

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * TODO: Anlegen von Produzenten; dabei muss sichergestellt sein, dass kein Name mehr als einmal vorkommt
     * creates an uploader (Anlegen von Produzenten)
     * @param name ein name
     */
    public void createUploader(String name) {
        Uploader uploader = new UploaderImpl(name);
        for (Uploader uploaderElement : this.uploaderLinkedList ) {
            if(uploaderElement.getName() == name){
                System.out.println("Uploader " + name + " vergeben");
            } else {
                this.uploaderLinkedList.add(uploader);
                System.out.println("Uploader " + name + " created");
                return;
            }
        }
    }

    /**
     * TODO: Abruf aller Produzenten mit der Anzahl der ihrer Mediadateien
     * @return liefert gesamte DB LinkedList
     */
    public LinkedList<Uploader> readUplaoder() {
        return this.uploaderLinkedList;
    }

    /**
     * TODO: Löschen eines bestimmten Produzenten(Uploader)
     * @param dataNr Nummer der zu löschenden Datei in DB ArrayList
     */
    public void delete(String name) {
        for (Uploader uploaderElement : this.uploaderLinkedList ) {
            if (uploaderElement.getName() == name) {
                this.uploaderLinkedList.remove(uploaderElement);
                System.out.println("uploader " + name + " deleted");
            }
        }
    }
}
