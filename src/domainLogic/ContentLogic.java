package domainLogic;

import mediaDB.util.Address;
import mediaDB.*;

import mediaDB.util.MediaType;
import observerPattern.observables.ObservableCounter;
import observerPattern.observables.ObservableMapSize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Verwaltung von verschiedenem Content(Audio, Video, etc.)
 */
public class ContentLogic extends Observable implements Serializable {
    private Map<String, DataImpl> mediaContentMap = new HashMap<>();

    public Map<String, DataImpl> getMediaContentMap() {
        return mediaContentMap;
    }

    private ObservableMapSize observableMapSize; //Map size
    public ContentLogic(long size) {
        this.observableMapSize = new ObservableMapSize(BigDecimal.valueOf(size));
    }
    public ObservableMapSize getObservableMapSize() {
        return observableMapSize;
    }

    private ObservableCounter observableCounter = new ObservableCounter(); //Adressvergabe

    /**
     * Hochladen von Mediendateien verschieden Typs, zusammen mit einer Adresse und einem Uploader und anderen Daten(Bitrate etc.)
     * TODO: es ist zu prüfen, dass die Gesamtkapazität nicht überschritten wird, dafür ist die Dateigröße in size definiert
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     */
    public boolean createContent(String mediaType, String uploaderName, String tags, int bitrate, long laenge) {
        observableCounter.increment(); //Zaehle Counter eins hoch (keine selben Adressen bis Long.MAX_VALUE) startet bei null durch dieses increment //TODO: Threadsicherheit
        DataImpl data = new DataImpl(mediaType, uploaderName, tags, bitrate, laenge);
        data.giveAddress(observableCounter.getCounter());
        if(this.mediaContentMap.containsKey(data.getAddress())){
            return false;
        }else{
            this.mediaContentMap.put(data.getAddress(), data);
            this.observableMapSize.setSize(data.getSize().longValue());
            return true;
        }
    }

    /**
     * zählt einen AccessCounter um ++ hoch beim access
     * @param address Nummer der Datei in der mediaContentMap
     */
    public boolean update (String address) {
        if(this.mediaContentMap.containsKey(address)){
            this.mediaContentMap.get(address).update();
            return true;
        }else{
            return false;
        }
    }


    /**
     * Weist einen Tag aus den vier gegeben zu (Animal, Tutorial, Lifestyle, News)
     *
     * @param tag Name (Animal, Tutorial, Lifestyle, News)
     * @param address position der Mediendatei zu der tag hinzugefügt werden soll
     */
    /*
    public boolean createTag(String tag, String address) {

        //TODO
        if (this.observableAddressDataHashMap != null) {
            if (this.observableAddressDataHashMap.containsKey(address)) {
                this.observableAddressDataHashMap.get(address)
            }
            return false;
        }


        public LinkedList<Data> readContentByType (String mediaType){
            LinkedList<Data> tempContentLinkedList = new LinkedList<>();

            switch (mediaType) {
                case "All":
                    if (this.observableAddressDataHashMap != null) {
                        for (Data listElement : this.observableAddressDataHashMap) {
                            tempContentLinkedList.add(listElement);
                        }
                        return tempContentLinkedList;
                    }
                    break;

                case "Audio":
                    if (this.observableAddressDataHashMap != null) {
                        for (Data listElement : this.observableAddressDataHashMap) {
                            if (listElement instanceof Audio) {
                                tempContentLinkedList.add(listElement);
                            }
                        }
                        return tempContentLinkedList;
                    }
                    break;

                case "Video":
                    if (this.observableAddressDataHashMap != null) {
                        //tempContentLinkedList.clear();
                        for (Data listElement : this.observableAddressDataHashMap) {
                            if (listElement instanceof Video) {
                                tempContentLinkedList.add(listElement);
                            }
                        }
                        return tempContentLinkedList;
                    }
                    break;

                default:
                    return null;
            }
            return tempContentLinkedList;
        }
     */


    /**
     * TODO: Abruf aller vergebenen bzw. nicht vergebenen Tags in der Verwaltung
     * @return Linkedlist of Tags
     */
/*
        public LinkedList<Content> readContentByTags (String tag)
        { //TODO: hier ist was falsch generell im Verständnis der methode
            if (this.observableAddressDataHashMap != null && this.observableAddressDataHashMap.size() != 0) {
                for (int i = 0; i < this.observableAddressDataHashMap.size(); i++) {
                    if (this.observableAddressDataHashMap.get(i).getTags() == observableTag.getTagList()) ;
                    if (listElement.getTags().contains(tag)) {
                        tempContentLinkedList.add(listElement);
                    }
                }
                return tempContentLinkedList;
            }
            return null;
        }
*/

    /**
     * Zum Lesen von Content nach Typ
     * @param mediaType "All", "Audio", "Video", etc...
     */
    /*
    public LinkedList<Content> readContentByType(String mediaType){

    }
     */


    /**
     * TODO: Löschen einer bestimmten Mediadatei (z.B.: Audio, Video)
     * @param address Addresse (zahl) der zu löschenden Datei in DB LinkedList
     */
/*
        public boolean deleteSingleContent (String address){
            if (this.observableAddressDataHashMap != null && this.observableAddressDataHashMap.size() > Integer.parseInt(address)) {
                for (Data listElement : this.observableAddressDataHashMap) {
                    if (listElement.getAddress() == address) {
                        this.observableAddressDataHashMap.remove(listElement);
                        return true;
                    }
                }
            }
            return false;
        }
    }

 */
}
