package domainLogic;

import mediaDB.*;

import java.util.LinkedList;

/**
 * Verwaltung von Content
 */
public class GLContentImpl {

    private LinkedList<Content> contentLinkedList = new LinkedList<>(); //evtl doch lieber HashMap wg adresse??

    private Integer addressCount = 0; //vergabe der adressen

    /**
     * TODO: Uploader zuerst erstellen dann Mediafile
     * Hochladen von Mediadateien verschiedenn typs
     * TODO: beim Hochladen wird eine Abrufadresse vergeben (address); zu keinem Zeitpunkt können mehrere Mediadateien innerhalb der Verwaltung die gleiche Abrufadresse haben
     * TODO: beim Hochladen wird ein Upload-Datum vergeben
     * TODO: es ist zu prüfen, dass die Gesamtkapazität nicht überschritten wird, dafür ist die Dateigröße in size definiert
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     * @param contentType
     * @param uploaderName
     * @param tagCollection nur übergangsweise, evtl auch regex string
     * @param bitrate
     * @param laenge
     */
    public LinkedList<Content>/*TEST*/ createContent(String contentType, String uploaderName, String tagCollection, int bitrate, long laenge) {

        switch(contentType){
            case "Audio":
                Audio audio = new AudioImpl(this.addressCount++, uploaderName, bitrate, laenge, tagCollection);
                this.contentLinkedList.add(audio);
            case "Video":
                Video video = new VideoImpl(); //TODO
                this.contentLinkedList.add(video);
            //case "LicensedAudio": break;//TODO
            //case "LicensedVideo": break;//TODO
            default:
                break;
        }
        return this.contentLinkedList; /*TEST*/
    }

    /**
     * Weist einen Tag aus den vier gegeben zu (Animal,Tutorial,Lifestyle,News)
     *
     * @param tag Name (Animal,Tutorial,Lifestyle,News)
     * @param dataNr position der Mediendatei zu der tag hinzugefügt werden soll
     */
    public LinkedList<Content>/*TEST*/ createTag(String tag, String address) {
//TODO


        return this.contentLinkedList;
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
     * @param address Nummer der Datei in der DB LinkedList
     */
    public long update(String address) {
        for (Content listElement : this.contentLinkedList) {
            if (listElement.getAddress() == address) {
                return listElement.getAccessCount();
            } //irgendwie unschön evtl doch lieber mit hashmap^^?
        }
        return -1;
    }

    /**
     * TODO: Löschen einer bestimmten Mediadatei (z.B.: Audio, Video)
     * @param address Nummer der zu löschenden Datei in DB LinkedList
     */
    public void deleteOne(String address) {
       if(this.contentLinkedList != null && this.contentLinkedList.size() > Integer.parseInt(address)) {
           for (Content listElement : this.contentLinkedList) {
               if (listElement.getAddress() == address) {
                   this.contentLinkedList.remove(listElement);
               } //evtl auch mit Hashmap einfacher...
           }
        }
    }
}
