package domainLogic;

import mediaDB.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GLContentImpl implements GLContent {

    LinkedList<Content> contentLinkedList = new LinkedList<>();


    @Override
    public void create(MediaContent mediaContent) {
        this.contentLinkedList.add(mediaContent);
    }

    @Override
    public LinkedList<Content> readAll(int typ) {
        LinkedList<Content> tempContentLinkedList = new LinkedList<>();
        switch(typ){
            case(0): //0 for all
                if(this.contentLinkedList != null){
                    tempContentLinkedList.clear();
                    for (Content listElement : this.contentLinkedList) {
                            tempContentLinkedList.add(listElement);
                    }
                    return tempContentLinkedList;
                } break;
            case(1): //1 for Audio
                if(this.contentLinkedList != null){
                    tempContentLinkedList.clear();
                    for (Content listElement : this.contentLinkedList) {
                        if(listElement instanceof Audio){
                            tempContentLinkedList.add(listElement);
                        }
                    }
                    return tempContentLinkedList;
                } break;
            case(2): //2 for Video
                if(this.contentLinkedList != null){
                    tempContentLinkedList.clear();
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
        if(this.contentLinkedList != null){
            LinkedList<Content> tempContentLinkedList = new LinkedList<>();
            for (Content listElement : this.contentLinkedList) {
                if(listElement.getTags().equals(tag)){
                    tempContentLinkedList.add(listElement);
                }
                return tempContentLinkedList;
            }
        }
        return null;
    }

    @Override
    public long update(int dataNr) {
        return this.contentLinkedList.get(dataNr).getAccessCount();
    }

    @Override
    public void delete(int dataNr) {
       if(this.contentLinkedList.size() != 0 && this.contentLinkedList.size() > dataNr) {
            this.contentLinkedList.remove(dataNr);
        }
       return;
    }
}
