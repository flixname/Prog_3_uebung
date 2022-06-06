package domainLogic;

import eventSystem.infrastructure.UpdateCounterEvent;
import eventSystem.infrastructure.UpdateCounterEventHandler;
import mediaDB.*;

import java.util.LinkedList;

/**
 * Verwaltung von Content
 */
public class GLContentImpl {

    //UPDATE HANDLER//
    private UpdateCounterEventHandler updateCounterEventHandler;
    public void setUpdateSingleAccessCountEventHandler(UpdateCounterEventHandler updateCounterEventHandler){
        this.updateCounterEventHandler = updateCounterEventHandler;
    }

    //CONTENT LIST//
    private LinkedList<Content> contentLinkedList = new LinkedList<>(); //evtl doch lieber HashMap wg adresse??

    public LinkedList<Content> getContentLinkedList() { /*testing*/
        return contentLinkedList;
    }

    public void setContentLinkedList(LinkedList<Content> contentLinkedList) {
        this.contentLinkedList = contentLinkedList;
    }

    private Integer generalAddressAssignment = -1; //vergabe der adressen

    /**
     * Hochladen von Mediadateien verschiedenn typs
     * TODO: zu keinem Zeitpunkt können mehrere Mediadateien innerhalb der Verwaltung die gleiche Abrufadresse haben: evtl noch namen odso dazu
     * TODO: beim Hochladen wird ein Upload-Datum vergeben
     * TODO: es ist zu prüfen, dass die Gesamtkapazität nicht überschritten wird, dafür ist die Dateigröße in size definiert
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     * @param contentType
     * @param uploaderName
     * @param tags nur übergangsweise, evtl auch regex string
     * @param bitrate
     * @param laenge
     */
    public boolean createContent(String contentType, String uploaderName, String tags, int bitrate, long laenge) {

        switch(contentType){
            case "Audio":
                Audio audio = new AudioImpl(this.generalAddressAssignment+=1, uploaderName, tags, bitrate, laenge);
                this.contentLinkedList.add(audio);
                break;
            case "Video": //TODO
                Video video = new VideoImpl();
                this.contentLinkedList.add(video);
                break;
            //case "LicensedAudio": break;//TODO
            //case "LicensedVideo": break;//TODO
            default:
                return false;
        }
        return false;
    }

    /**
     * Weist einen Tag aus den vier gegeben zu (Animal,Tutorial,Lifestyle,News)
     *
     * @param tag Name (Animal,Tutorial,Lifestyle,News)
     * @param address position der Mediendatei zu der tag hinzugefügt werden soll
     */
    public boolean/*TEST*/ createTag(String tag, String address) {
//TODO

        return false;
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
    public LinkedList<Content> readByTags(Tag tag) { //TODO: hier ist was falsch generell im Verständnis der methode
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
     * zählt einen AccessCounter um ++ hoch beim access
     * @param address Nummer der Datei in der DB LinkedList
     */
    public boolean update(String address) { //TODO: komplette contentlinkedlist in extra class Memory, diese hält nur die liste und reagiert auf Events, diese suche kommt dann in observable counter
        UpdateCounterEvent updateCounterEvent = new UpdateCounterEvent(this, address);
        for (int i = 0; i < this.contentLinkedList.size(); i++) {
            if (this.contentLinkedList.get(i).getAddress() == address) {
                if(this.updateCounterEventHandler != null){
                    updateCounterEventHandler.handle(updateCounterEvent);
                }
                return true;
            }
        }
        return false;
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
               }
           }
        }
    }
}
