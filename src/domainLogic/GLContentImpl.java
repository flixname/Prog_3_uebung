package domainLogic;

import mediaDB.*;

import java.util.Collection;
import java.util.LinkedList;

public class GLContentImpl implements GLContent {

    private LinkedList<Content> contentLinkedList = new LinkedList<>();

    @Override
    public void createContent(MediaContent mediaContent, Uploader uploader, Tag tag) {
        this.contentLinkedList.add(mediaContent);
    }

    @Override
    public Collection<Tag> createTag(int tag, int dataNr) {
        Collection<Tag> tempCollectionOfTags = this.contentLinkedList.get(dataNr).getTags();
        switch(tag){
            case 0: //Animal
                if(tempCollectionOfTags.contains(Tag.Animal)){break;}
                tempCollectionOfTags.add(Tag.Animal);
                break;
            case 1: //Tutorial
                if(tempCollectionOfTags.contains(Tag.Tutorial)){break;}
                this.contentLinkedList.get(dataNr).getTags().add(Tag.Tutorial);
                break;
            case 2: //Lifestyle
                if(tempCollectionOfTags.contains(Tag.Lifestyle)){break;}
                this.contentLinkedList.get(dataNr).getTags().add(Tag.Lifestyle);
                break;
            case 3: //News
                if(tempCollectionOfTags.contains(Tag.News)){break;}
                this.contentLinkedList.get(dataNr).getTags().add(Tag.News);
                break;
            default:
                break;
        }
        // this.contentLinkedList.get(dataNr).getTags()... ok fail, wie komme ich an die liste zum adden der tags...
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
