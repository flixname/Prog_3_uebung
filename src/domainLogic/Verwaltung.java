package domainLogic;

import mediaDB.AudioVideo;
import mediaDB.Content;
import mediaDB.Uploader;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * Interface zur Verwaltung von Daten und Uploadern(?)
 */
public interface Verwaltung {


    /**
     * Bekommt Datei, welche in die DB geladen werden soll
     * @param data dateityp audio oder video
     */
    void create(Content data);

    /**
     * bekommt Namen von datei die gelesen werden soll
     * @param dataNr Name der zu lesenden Datei
     * @return liefert die Datei
     * @throws NullPointerException falls nichts da ist
     */
    HashMap<Integer,? super Content> read();

    /**
     * liefert alle Dateien
     * @return liefert sämtliche Dateinamen aus der db
     * @throws NullPointerException falls nichts da ist
     */
    String printAll(PrintStream os) throws NullPointerException;

    /**
     * erneuert bestehende Datei
     * @param dataNr Name der zu updatenden Datei
     */
    long update(Integer dataNr);

    /**
     * löscht eine Datei
     * @param dataNr Name der zu löschenden Datei
     */
    void delete(Integer dataNr);

    /**
     * löscht alle Dateien
     * @throws NullPointerException wenn nichts zum löschen da ist
     */
    void deleteAll() throws NullPointerException;

    /**
     * erstellt einen uploadereintrag
     * TODO:
     */
    void createUploader(Uploader name);

}
