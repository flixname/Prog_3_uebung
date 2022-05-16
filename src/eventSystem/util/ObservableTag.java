package eventSystem.util;

import mediaDB.Tag;

import java.util.LinkedList;


public class ObservableTag {

    private LinkedList<Tag> tagCollection;

    public LinkedList<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(LinkedList<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    public ObservableTag(LinkedList<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    /*
    public void addTag(Tag tag) {
        this.tagCollection.add(tag);
        /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
}
