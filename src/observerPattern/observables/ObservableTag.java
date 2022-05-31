package observerPattern.observables;

import mediaDB.Tag;

import java.util.LinkedList;

public class ObservableTag {

    private LinkedList<Tag> tagLinkedList = new LinkedList<>();

    public ObservableTag(String tags) {
        String[] splitTextContent = tags.split(", ");
        for (int i = 0; i < splitTextContent.length; i++) {
            if(this.tagLinkedList.contains(splitTextContent[i]) == false)
                this.tagLinkedList.add(stringToTagConverter(splitTextContent[i]));
        }
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

    public void deleteTags(String tag){
        this.tagLinkedList.remove(stringToTagConverter(tag));
        System.out.println("deleted " + tag + "from tag collection");
    }

    public LinkedList<Tag> getTagList() {
        return tagLinkedList;
    }
}
