package domainLogic;

import eventSystem.util.Bitrate;
import eventSystem.util.Laenge;
import mediaDB.Content;
import mediaDB.MediaContent;
import mediaDB.Tag;
import mediaDB.Uploader;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Interface zur Verwaltung von Content
 */
public interface GLContent {

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * Hochladen von Mediadateien verschiedenn typs
     * TODO: beim Hochladen wird eine Abrufadresse vergeben (address); zu keinem Zeitpunkt können mehrere Mediadateien innerhalb der Verwaltung die gleiche Abrufadresse haben
     * TODO: beim Hochladen wird ein Upload-Datum vergeben
     * TODO: es ist zu prüfen, dass die Gesamtkapazität nicht überschritten wird, dafür ist die Dateigröße in size definiert
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     * @param mediaContent unterstützt werden alle Typen die von MediaContent ableiten
     */
    void createContent(MediaContent mediaContent, Uploader uploader, Tag tag, Bitrate bitrate, Laenge laenge);

    /**
     * Weist einen Tag aus den vier gegeben zu (Animal,Tutorial,Lifestyle,News)
     *
     * @param tag Name (Animal,Tutorial,Lifestyle,News)
     * @param dataNr position der Mediendatei zu der tag hinzugefügt werden soll
     */
    Collection<Tag> createTag(int tag, int dataNr);

    /**
     * zum lesen von MediaContent (0), Audio(1), Video(2)
     * @return liefert gesamte DB LinkedList
     */
    LinkedList<Content> readByContentType(int typ);

    /**
     * TODO: Abruf aller vergebenen bzw. nicht vergebenen Tags in der Verwaltung
     * @return Linkedlist of Tags
     */
    LinkedList<Content> readByTags(Tag tag);

    /**
     * TODO: Observable zum laufen bringen
     * zählt den Counter um ++ hoch
     * @param dataNr Nummer der Datei in der DB LinkedList
     */
    long update(int dataNr);

    /**
     * TODO: Löschen einer bestimmten Mediadatei (z.B.: Audio, Video)
     * @param dataNr Nummer der zu löschenden Datei in DB LinkedList
     */
    void deleteOne(int dataNr);
}
