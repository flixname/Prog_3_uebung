package observerPattern.observables;

import mediaDB.Tag;

import java.util.Collection;
import java.util.LinkedList;

public class ObservableTag {

    private Collection<Tag> tagCollection = new LinkedList<>();

    public ObservableTag(Collection<String> tagCollection) {
        for (String listElement : tagCollection) { this.tagCollection.add(stringToTagConverter(listElement)); }
        /*
        this.setChanged(); //TODO: Subscribe notify funtionality
        this.notifyObservers();
        */
    }

    public ObservableTag() {
        System.out.println("No Tag given.");
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
}
