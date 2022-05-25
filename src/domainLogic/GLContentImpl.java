package domainLogic;

import domainLogic.util.Address;
import mediaDB.*;
import observerPattern.observers.AddressObserver;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Verwaltung von Content
 */
public class GLContentImpl {

    private LinkedList<Content> contentLinkedList = new LinkedList<>();

    private Integer addressCount = 0; //vergabe der adressen

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * Hochladen von Mediadateien verschiedenn typs
     * TODO: beim Hochladen wird eine Abrufadresse vergeben (address); zu keinem Zeitpunkt können mehrere Mediadateien innerhalb der Verwaltung die gleiche Abrufadresse haben
     * TODO: beim Hochladen wird ein Upload-Datum vergeben
     * TODO: es ist zu prüfen, dass die Gesamtkapazität nicht überschritten wird, dafür ist die Dateigröße in size definiert
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     * @param dataType
     * @param uploaderName
     * @param tagCollection nur übergangsweise, evtl auch regex string
     * @param bitrate
     * @param laenge
     */
    public Content createContent(String dataType, String uploaderName, Collection<Tag> tagCollection, BigDecimal bitrate, Duration laenge) { //TODO: mehrfach tag

        switch(dataType){
            case "Audio":
                Audio audio = new AudioImpl(this.addressCount++, uploaderName, tagCollection, bitrate, laenge);
                this.contentLinkedList.add(audio);
                return audio;
            case "Video":
                Video video = new VideoImpl();
                this.contentLinkedList.add(video);
                break;
            //case "LicensedAudio": break;
            //case "LicensedVideo": break;
            default:
                break;
        }
        return null;
    }

    /**
     * Weist einen Tag aus den vier gegeben zu (Animal,Tutorial,Lifestyle,News)
     *
     * @param tag Name (Animal,Tutorial,Lifestyle,News)
     * @param dataNr position der Mediendatei zu der tag hinzugefügt werden soll
     */
    public Collection<Tag> createTag(String tag, int dataNr) {
        Collection<Tag> tempCollectionOfTags = this.contentLinkedList.get(dataNr).getTags();
        //oder komplett als interface....oder abstract class

        //Collection<Tag> tempCollectionOfTags = null;
        switch(tag){
            case "Animal": //Animal
                if(tempCollectionOfTags.contains(Tag.Animal)){break;}
                tempCollectionOfTags.add(Tag.Animal);
                break;
            case "Tutorial": //Tutorial
                if(tempCollectionOfTags.contains(Tag.Tutorial)){break;}
                tempCollectionOfTags.add(Tag.Tutorial);
                break;
            case "Lifestyle": //Lifestyle
                if(tempCollectionOfTags.contains(Tag.Lifestyle)){break;}
                tempCollectionOfTags.add(Tag.Lifestyle);
                break;
            case "News": //News
                if(tempCollectionOfTags.contains(Tag.News)){break;}
                tempCollectionOfTags.add(Tag.News);
                break;
            default:
                break;
        }

        return tempCollectionOfTags; //TODO: ok wie weiter? LIst muss ja im Mngmt überschrieben werden
    }

    /**
     * zum lesen von Content
     * @param type "All", "Audio", "Video", etc...
     */
    public LinkedList<Content> readByContentType(String type) {
        LinkedList<Content> tempContentLinkedList = new LinkedList<>();

        switch(type){
            case "All":
                if(this.contentLinkedList != null){
                    for (Content listElement : this.contentLinkedList) { tempContentLinkedList.add(listElement); }
                    return tempContentLinkedList;
                } break;

            case "Audio":
                if(this.contentLinkedList != null){
                    for (Content listElement : this.contentLinkedList) {
                        if(listElement instanceof Audio){
                            tempContentLinkedList.add(listElement);
                        }
                    }
                    return tempContentLinkedList;
                } break;

            case "Video":
                if(this.contentLinkedList != null){
                    //tempContentLinkedList.clear();
                    for (Content listElement : this.contentLinkedList) {
                        if(listElement instanceof Video){
                            tempContentLinkedList.add(listElement);
                        }
                    }
                    return tempContentLinkedList;
                } break;

            default:
                return null;
        }
        return tempContentLinkedList;
    }

    /**
     * TODO: Abruf aller vergebenen bzw. nicht vergebenen Tags in der Verwaltung
     * @return Linkedlist of Tags
     */
    public LinkedList<Content> readByTags(Tag tag) { //TODO: hier ist was falsch generell im verständnis der methode
        if(this.contentLinkedList != null && this.contentLinkedList.size() != 0){
            LinkedList<Content> tempContentLinkedList = new LinkedList<>();
            for (Content listElement : this.contentLinkedList) {
                if(listElement.getTags().contains(tag)){
                    tempContentLinkedList.add(listElement);
                }
            }
            return tempContentLinkedList;
        }
        return null;
    }

    /**
     * zählt einen AccessCounter um ++ hoch
     * @param dataNr Nummer der Datei in der DB LinkedList
     */
    public long update(int dataNr) {
        return this.contentLinkedList.get(dataNr).getAccessCount();
    }

    /**
     * TODO: Löschen einer bestimmten Mediadatei (z.B.: Audio, Video)
     * @param dataNr Nummer der zu löschenden Datei in DB LinkedList
     */
    public void deleteOne(int dataNr) {
       if(this.contentLinkedList != null && this.contentLinkedList.size() != 0 && this.contentLinkedList.size() > dataNr) {
            this.contentLinkedList.remove(dataNr);
        }
    }
}
