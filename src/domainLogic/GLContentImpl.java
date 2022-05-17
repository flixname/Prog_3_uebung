package domainLogic;

import mediaDB.*;

import java.util.Collection;
import java.util.LinkedList;

public class GLContentImpl implements GLContent {

    private LinkedList<Content> contentLinkedList = new LinkedList<>();



    private ObservableCounter observableCounter;
    private Bitrate bitrate;
    private Laenge laenge;

    private Integer addressCount;

    @Override
    public void createContent(String dataType, String uploaderName, String tag, Bitrate bitrate, Laenge laenge) { //dataType 1 Audio oder 2 Video TODO: mehrfach tag

        switch(dataType){
            case "Audio":
                Uploader uploader = new UploaderImpl(uploaderName);
                this.addressCount = this.addressCount++; //adresscounter zählt hoch bei jeder datei und wird zu string geformt in der Addressclass
                Address address = new Address(this.addressCount);
                ObservableTag observableTag = new ObservableTag();
                Audio audio = new AudioImpl(address, observableTag );
                this.contentLinkedList.add(audio);
                this.contentLinkedList.
                        break;
            case "Video":
                Video video = new VideoImpl();
                this.contentLinkedList.add(video);
                break;
            //case "LicensedAudio": break;
            //case "LicensedVideo": break;
            default:
                break;
        }
    }

    @Override
    public Collection<Tag> createTag(String tag, int dataNr) {
        Collection<Tag> tempCollectionOfTags = this.contentLinkedList.get(dataNr).getTags();
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
        return tempCollectionOfTags;
    }

    @Override
    public LinkedList<Content> readByContentType(int typ) {
        LinkedList<Content> tempContentLinkedList = new LinkedList<>();
        switch(typ){
            case(0): //0 for all
                if(this.contentLinkedList != null){
                    //tempContentLinkedList.clear();
                    for (Content listElement : this.contentLinkedList) { tempContentLinkedList.add(listElement); }
                    return tempContentLinkedList;
                } break;
            case(1): //1 for Audio
                if(this.contentLinkedList != null){
                    //tempContentLinkedList.clear();
                    for (Content listElement : this.contentLinkedList) {
                        if(listElement instanceof Audio){
                            tempContentLinkedList.add(listElement);
                        }
                    }
                    return tempContentLinkedList;
                } break;
            case(2): //2 for Video
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
        return null;
    }

    @Override
    public LinkedList<Content> readByTags(Tag tag) {
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

    @Override
    public long update(int dataNr) {
        return this.contentLinkedList.get(dataNr).getAccessCount();
    }

    @Override
    public void deleteOne(int dataNr) {
       if(this.contentLinkedList != null && this.contentLinkedList.size() != 0 && this.contentLinkedList.size() > dataNr) {
            this.contentLinkedList.remove(dataNr);
        }
    }
}
