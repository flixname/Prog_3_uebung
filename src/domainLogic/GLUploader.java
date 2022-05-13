package domainLogic;

import mediaDB.Uploadable;
import mediaDB.Uploader;

import java.util.LinkedList;

public interface GLUploader {

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * TODO: Anlegen von Produzenten; dabei muss sichergestellt sein, dass kein Name mehr als einmal vorkommt
     * creates an uploader (Anlegen von Produzenten)
     * @param name ein name
     */
    void createUploader(String name);

    /**
     * TODO: Abruf aller Produzenten mit der Anzahl der ihrer Mediadateien
     * @return liefert gesamte DB LinkedList
     */
    LinkedList<Uploader> readUplaoder();

    /**
     * TODO: Löschen eines bestimmten Produzenten(Uploader)
     * @param dataNr Nummer der zu löschenden Datei in DB ArrayList
     */
    void delete(Integer dataNr);
}
