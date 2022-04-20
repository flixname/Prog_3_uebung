package verwaltung;

import mediaDB.Uploader;

import java.io.PrintStream;

/**
 * Interface zur Verwaltung von Daten und Uploadern(?)
 */
public interface Verwaltung {


    /**
     * Bekommt Datei, welche in die DB geladen werden soll
     * @param data die Datei, welche erstellt werden soll im DB
     * @throws SameDataExistsException wenn in der db ein gleicher eintrag vorhanden ist
     * @throws DataNrOccupiedException wenn an angegebener stelle schon ein eintrag ist
     */
    void create(Integer dataNr, AudioVideoController data) throws SameDataExistsException, DataNrOccupiedException;

    /**
     * bekommt Namen von datei die gelesen werden soll
     * @param dataNr Name der zu lesenden Datei
     * @return liefert die Datei
     * @throws NullPointerException falls nichts da ist
     */
    mediaDB.AudioVideo read(Integer dataNr) throws NullPointerException;

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
    void update(Integer dataNr, AudioVideoController update) throws NullPointerException, SameDataExistsException;

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
     * TODO: Uploader existiert bereits
     */
    void createUploader(Uploader name);

}
