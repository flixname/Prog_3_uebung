package domainLogic;

import mediaDB.AudioVideo;
import mediaDB.Uploader;
import verwaltung.DataNrOccupiedException;
import verwaltung.SameDataExistsException;

import java.io.PrintStream;

/**
 * Interface zur Verwaltung von Daten und Uploadern(?)
 */
public interface Verwaltung {


    /**
     * Bekommt Datei, welche in die DB geladen werden soll
     * @param data die Datei, welche erstellt werden soll im DB
     */
    void create(Integer dataNr, AudioVideo data);

    /**
     * bekommt Namen von datei die gelesen werden soll
     * @param dataNr Name der zu lesenden Datei
     * @return liefert die Datei
     * @throws NullPointerException falls nichts da ist
     */
    AudioVideo read(Integer dataNr) throws NullPointerException;

    /**
     * liefert alle Dateien
     * @return liefert sämtliche Dateinamen aus der db
     * @throws NullPointerException falls nichts da ist
     */
    String printAll(PrintStream os) throws NullPointerException;

    /**
     * erneuert bestehende Datei
     * @param dataNr Name der zu updatenden Datei
     * @param update Der neue Wert für z.B. Framerate
     * @throws NullPointerException wenn nichts da ist zum speichern
     * @throws DataNrOccupiedException wenn same data schon vorhanden
     */
    void update(Integer dataNr);

    /**
     * löscht eine Datei
     * @param dataNr Name der zu löschenden Datei
     * @throws NullPointerException wenn an dem ort nichts da ist
     */
    void delete(Integer dataNr) throws NullPointerException;

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
