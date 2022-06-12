package domainLogic;

import domainLogic.util.Counter;
import mediaDB.*;
import model.ObservableContentMemory;
import observerPattern.observables.ObservableAccessCounter;
import observerPattern.observables.ObservableAddress;
import observerPattern.observables.ObservableCounter;
import observerPattern.observers.ContentMemoryObserver;
import observerPattern.observers.CounterObserver;

import java.util.Date;
import java.util.LinkedList;

/**
 * Verwaltung von verschiedenem Content(Audio, Video, etc.)
 */
public class GLContentImpl {

    private Counter counter = new Counter(); //Adressenvergabe

    private ObservableContentMemory observableContentMemory = new ObservableContentMemory();
    private ContentMemoryObserver contentMemoryObserver = new ContentMemoryObserver(observableContentMemory);

    private ObservableAccessCounter observableAccessCounter = new ObservableAccessCounter();
    private CounterObserver counterObserver = new CounterObserver(observableAccessCounter);


    public boolean createContent(String contentType, String uploaderName, String tags, int bitrate, long laenge) {
        observableContentMemory.addObserver(contentMemoryObserver);
        this.counter.increment();
        ObservableAddress observableAddress = new ObservableAddress(this.counter.getCounter());
        Date uploadDate = new Date();

        switch (contentType) {
            case "Audio":
                Data<Audio> audioData = new DataImpl<AudioImpl>(observableAddress, uploadDate, uploaderName, tags, bitrate, laenge);
                observableContentMemory.addData(observableAddress, audioData);
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
        public long update (String address) {
            observableAccessCounter.addObserver(counterObserver);
            this.observableContentMemory.

            /*
            for (int i = 0; i < this.observableAddressDataHashMap.size(); i++) {
                if (this.observableAddressDataHashMap.get(i).getAddress() == address) {
                    //TODO hier einen Beobachter einhängen um dann am counter hoch zuzählen
                    return -2;
                }
            }
            return -2;

             */
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
}
