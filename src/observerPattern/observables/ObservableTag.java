package observerPattern.observables;

import mediaDB.Tag;

import java.util.Collection;
import java.util.LinkedList;
//TODO: String to TAG conversion!!!

public class ObservableTag {

    private Collection<Tag> tagCollection = new LinkedList<>();


    public ObservableTag(String tag1, String tag2, String tag3, String tag4) {
        this.tagCollection.add(stringToTagConverter(tag1));
        this.tagCollection.add(stringToTagConverter(tag2));
        this.tagCollection.add(stringToTagConverter(tag3));
        this.tagCollection.add(stringToTagConverter(tag4));
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
        System.out.println("No Tag given.");  //evtl in die TagObserverklasse mit rein
                /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }


    public Tag stringToTagConverter(String tag){

        switch(tag){
            case "Animal": //Animal
                return Tag.Animal;
            case "Tutorial": //Tutorial
                return Tag.Tutorial;
            case "Lifestyle": //Lifestyle
                return Tag.Lifestyle;
            case "News": //News
                return Tag.News;
            default:
                return null;
        }
    }

    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(String tag) {
        this.tagCollection = tagCollection;
    }
}
