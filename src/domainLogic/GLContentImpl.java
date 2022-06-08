package domainLogic;

import mediaDB.*;
import observerPattern.observables.ObservableAddress;
import observerPattern.observables.ObservableCounter;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Verwaltung von verschiedenem Content(Audio, Video, etc.)
 */
public class GLContentImpl implements GLContent{


    private ObservableCounter observableCounter = new ObservableCounter(); //Adressenvergabe

    private HashMap<ObservableAddress, Data> observableAddressDataHashMap = new HashMap<>();  //auslagern?

    public HashMap<ObservableAddress, Data> getObservableAddressDataHashMap() {
        return observableAddressDataHashMap;
    }

    public void setObservableAddressDataHashMap(HashMap<ObservableAddress, Data> observableAddressDataHashMap) {
        this.observableAddressDataHashMap = observableAddressDataHashMap;
    }

    /**
     * Hochladen von Mediendateien verschieden Typs, zusammen mit einer Adresse und einem Uploader und anderen Daten(Bitrate etc.)
     * TODO: zu keinem Zeitpunkt können mehrere Mediadateien innerhalb der Verwaltung die gleiche Abrufadresse haben
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

        Date uploadDate = new Date();
        ObservableAddress observableAddress = new ObservableAddress(this.observableCounter.increment());

        switch(contentType){
            case "Audio":
                Audio audio = new AudioImpl();
                Data<Audio, Uploadable> audioUploadableData = new DataImpl<Audio, Uploadable>(audio, uploadDate, uploaderName, tags, bitrate, laenge);
                this.observableAddressDataHashMap.put(observableAddress, audioUploadableData);
                break;
            case "Video":
                Video video = new VideoImpl();
                Data<Video, Uploadable> videoUploadableData = new DataImpl<Video, Uploadable>(video, uploadDate, uploaderName, tags, bitrate, laenge);
                this.observableAddressDataHashMap.put(observableAddress, videoUploadableData);
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
        if(this.observableAddressDataHashMap != null){
            if(this.observableAddressDataHashMap.containsKey(address)){
                Data tmp = this.observableAddressDataHashMap.get(address);
                t
                this.observableAddressDataHashMap.replace(address, tmp);
            }
        }
        return false;
    }

    /**
     * zum lesen von Content
     * @param type "All", "Audio", "Video", etc...
     */
    public LinkedList<Data> readContentByType(String type) {
        LinkedList<Data> tempContentLinkedList = new LinkedList<>();

        switch(type){
            case "All":
                if(this.observableAddressDataHashMap != null){
                    for (Data listElement : this.observableAddressDataHashMap) { tempContentLinkedList.add(listElement); }
                    return tempContentLinkedList;
                } break;

            case "Audio":
                if(this.observableAddressDataHashMap != null){
                    for (Data listElement : this.observableAddressDataHashMap) {
                        if(listElement instanceof Audio){
                            tempContentLinkedList.add(listElement);
                        }
                    }
                    return tempContentLinkedList;
                } break;

            case "Video":
                if(this.observableAddressDataHashMap != null){
                    //tempContentLinkedList.clear();
                    for (Data listElement : this.observableAddressDataHashMap) {
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
    public LinkedList<Content> readContentByTags(String tag) { //TODO: hier ist was falsch generell im Verständnis der methode
        if(this.observableAddressDataHashMap != null && this.observableAddressDataHashMap.size() != 0){
            LinkedList<Content> tempContentLinkedList = new LinkedList<>();
            for (Content listElement : this.observableAddressDataHashMap) {
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
    public long update(String address) { //TODO: komplette contentlinkedlist in extra class Memory, diese hält nur die liste und reagiert auf Events

        for (int i = 0; i < this.observableAddressDataHashMap.size(); i++) {
            if (this.observableAddressDataHashMap.get(i).getAddress() == address) {
                return this.observableAddressDataHashMap.get(i).getAccessCount();
            }
        }
        return -2;
    }

    /**
     * TODO: Löschen einer bestimmten Mediadatei (z.B.: Audio, Video)
     * @param address Nummer der zu löschenden Datei in DB LinkedList
     */
    public boolean deleteSingleContent(String address) {
       if(this.observableAddressDataHashMap != null && this.observableAddressDataHashMap.size() > Integer.parseInt(address)) {
           for (Content listElement : this.observableAddressDataHashMap) {
               if (listElement.getAddress() == address) {
                   this.observableAddressDataHashMap.remove(listElement);
                   return true;
               }
           }
        }
       return false;
    }
}
