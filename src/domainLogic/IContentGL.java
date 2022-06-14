package domainLogic;

import mediaDB.Content;

import java.util.LinkedList;

public interface IContentGL {

    /**
     * Hochladen von Mediendateien verschieden Typs, zusammen mit einer Adresse und einem Uploader und anderen Daten(Bitrate etc.)
     * TODO: zu keinem Zeitpunkt können mehrere Mediadateien innerhalb der Verwaltung die gleiche Abrufadresse haben
     * TODO: beim Hochladen wird ein Upload-Datum vergeben
     * TODO: es ist zu prüfen, dass die Gesamtkapazität nicht überschritten wird, dafür ist die Dateigröße in size definiert
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     *
     * @param contentType
     * @param uploaderName
     * @param tags         nur übergangsweise, evtl auch regex string
     * @param bitrate
     * @param laenge
     */
    boolean createContent(String contentType, String uploaderName, String tags, int bitrate, long laenge);


    /**
     * Weist einen Tag aus den vier gegeben zu (Animal,Tutorial,Lifestyle,News)
     *
     * @param tag Name (Animal,Tutorial,Lifestyle,News)
     * @param address position der Mediendatei zu der tag hinzugefügt werden soll
     */
    boolean createTag(String tag, String address);

    /**
     * Zum Lesen von Content nach Typ
     * @param type "All", "Audio", "Video", etc...
     */
    LinkedList<Content> readContentByType(String type);

    /**
     * TODO: Abruf aller vergebenen bzw. nicht vergebenen Tags in der Verwaltung
     * @return Linkedlist of Tags
     */
    LinkedList<Content> readContentByTags(String tag);

    /**
     * zählt einen AccessCounter um ++ hoch beim access
     * @param address Nummer der Datei in der DB LinkedList
     */
    long update(String address);

    /**
     * TODO: Löschen einer bestimmten Mediadatei (z.B.: Audio, Video)
     * @param address Nummer der zu löschenden Datei in DB LinkedList
     */
    boolean deleteSingleContent(String address);
}
