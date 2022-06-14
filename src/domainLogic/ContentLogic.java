package domainLogic;

import domainLogic.util.Address;
import mediaDB.*;
import observerPattern.observables.ObservableCounter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Verwaltung von verschiedenem Content(Audio, Video, etc.)
 */
public class ContentLogic implements Serializable {
    private ObservableCounter observableCounter = new ObservableCounter(); //Adressvergabe initialisierung mit -1
    private Map<String, DataImpl> addressMediaContentHashMap = new HashMap<>();

    public boolean createContent(String contentType, String uploaderName, String tags, int bitrate, long laenge) {
        Date uploadDate = new Date();
        this.observableCounter.increment(); //Zaehle Counter eins hoch (keine selben adressen bis Long.MAX_VALUE) startet bei null durch diese increment
        Address address = new Address(this.observableCounter.getCounter());

        switch (contentType) {
            case "Audio":
                DataImpl<Audio> audioData = new DataImpl<>(address, uploaderName, tags, bitrate, laenge);
                this.addressMediaContentHashMap.put(address.getAddress(), audioData);
                return true;
            case "Video":
                DataImpl<Video> videoData = new DataImpl<>(address, uploaderName, tags, bitrate, laenge);
                this.addressMediaContentHashMap.put(address.getAddress(), videoData);
                return true;
            case "LicensedAudio":
                DataImpl<LicensedAudio> licensedAudioData = new DataImpl<>(address, uploaderName, tags, bitrate, laenge);
                this.addressMediaContentHashMap.put(address.getAddress(), licensedAudioData);
                return true;
            case "LicensedVideo":
                DataImpl<LicensedVideo> licensedVideoData = new DataImpl<>(address, uploaderName, tags, bitrate, laenge);
                this.addressMediaContentHashMap.put(address.getAddress(), licensedVideoData);
                return true;
            default:
                return false;
        }
    }
    /*
    public boolean createTag(String tag, String address) {

        //TODO
        if (this.observableAddressDataHashMap != null) {
            if (this.observableAddressDataHashMap.containsKey(address)) {
                this.observableAddressDataHashMap.get(address)
            }
            return false;
        }


        public LinkedList<Data> readContentByType (String type){
            LinkedList<Data> tempContentLinkedList = new LinkedList<>();

            switch (type) {
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
        public boolean update (String address) {
            if (this.addressMediaContentHashMap != null && this.addressMediaContentHashMap.size() != 0) {
                this.getAddressMediaContentHashMap().get(address).update();
            }
            return false;
        }

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

    public Map<String, DataImpl> getAddressMediaContentHashMap() {
        return addressMediaContentHashMap;
    }

    public void setAddressMediaContentHashMap(Map<String, DataImpl> addressMediaContentHashMap) {
        this.addressMediaContentHashMap = addressMediaContentHashMap;
    }
}
