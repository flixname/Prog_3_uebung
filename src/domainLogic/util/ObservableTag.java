package domainLogic.util;

import mediaDB.Tag;

import java.util.Collection;
import java.util.LinkedList;


public class ObservableTag {

    private Collection<Tag> tagCollection = new LinkedList<>();

    public ObservableTag(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    public ObservableTag(Tag tag1, Tag tag2, Tag tag3, Tag tag4) {
        this.tagCollection.add(tag1);
        this.tagCollection.add(tag2);
        this.tagCollection.add(tag3);
        this.tagCollection.add(tag4);
        /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }

    public ObservableTag(Tag tag1, Tag tag2, Tag tag3) {
        this.tagCollection.add(tag1);
        this.tagCollection.add(tag2);
        this.tagCollection.add(tag3);
                /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }

    public ObservableTag(Tag tag1, Tag tag2) {
        this.tagCollection.add(tag1);
        this.tagCollection.add(tag2);
                /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }

    public ObservableTag(Tag tag1) {
        this.tagCollection.add(tag1);
                /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }

    public ObservableTag() {
        this.tagCollection.add(null);
                /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }

    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(String tag) {
        this.tagCollection = tagCollection;
    }
}
