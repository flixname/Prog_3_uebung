package domainLogic;

import mediaDB.Uploadable;
import mediaDB.Uploader;

import java.util.LinkedList;

public interface GLUploader {

    /**
     * TODO: Anlegen von Produzenten; dabei muss sichergestellt sein, dass kein Name mehr als einmal vorkommt
     * Anlegen von Produzenten;
     * @param uploadable unterstützt werden alle Typen die von Uploadable ableiten
     */
    void create(Uploadable uploadable);

    /**
     * TODO: Abruf aller Produzenten mit der Anzahl der ihrer Mediadateien
     * @return liefert gesamte DB LinkedList
     */
    LinkedList<Uploader> read();

    /**
     * TODO: Löschen eines bestimmten Produzenten(Uploader)
     * @param dataNr Nummer der zu löschenden Datei in DB ArrayList
     */
    void delete(Integer dataNr);
}
