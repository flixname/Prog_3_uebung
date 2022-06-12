package domainLogic;

import mediaDB.*;
import observerPattern.observables.ObservableAddress;
import observerPattern.observables.ObservableCounter;
import observerPattern.observables.ObservableTag;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Verwaltung von verschiedenem Content(Audio, Video, etc.)
 */
public class GLContentImpl implements GLContent {

    private ObservableCounter observableCounter = new ObservableCounter(); //Adressenvergabe


    public boolean createContent(String contentType, String uploaderName, String tags, int bitrate, long laenge) {

        Date uploadDate = new Date();
        ObservableAddress observableAddress = new ObservableAddress(this.observableCounter.increment());

        switch (contentType) {
            case "Audio":
                //Audio audio = new AudioImpl();
                Data<Audio> audioData = new DataImpl<AudioImpl>(observableAddress, uploadDate, uploaderName, tags, bitrate, laenge);
                this.observableAddressDataHashMap.put(observableAddress, audioData);
                break;
            case "Video":
                //Video video = new VideoImpl();
                //Data<Video> videoData = new DataImpl<VideoImpl>(observableAddress, uploadDate, uploaderName, tags, bitrate, laenge);
                //this.observableAddressDataHashMap.put(observableAddress, videoData);
                break;
            //case "LicensedAudio": break;//TODO
            //case "LicensedVideo": break;//TODO
            default:
                return false;
        }
        return false;
    }

    public boolean/*TEST*/ createTag(String tag, String address) {
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

        public long update (String address)
        { //TODO: komplette contentlinkedlist in extra class Memory, um dann observervable memory zu machen?

            for (int i = 0; i < this.observableAddressDataHashMap.size(); i++) {
                if (this.observableAddressDataHashMap.get(i).getAddress() == address) {
                    //TODO hier einen Beobachter einhängen um dann am counter hoch zuzählen
                    return -2;
                }
            }
            return -2;
        }


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
}
