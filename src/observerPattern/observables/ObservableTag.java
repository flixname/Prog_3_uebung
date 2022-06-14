package observerPattern.observables;

import mediaDB.Tag;

import java.io.Serializable;
import java.util.HashMap;

public class ObservableTag implements Serializable {

    private HashMap<Integer, Tag> tagHashMap = new HashMap<>();

    public ObservableTag() {
    }

    public ObservableTag(String tags) {
        String[] splitTextContent = tags.split(", ");
        if(splitTextContent != null){
            for (int i = 0; i < splitTextContent.length; i++) {
                addTag(splitTextContent[i]);
            }
        }
    }

    public void addTag(String tag){
        switch(tag){
            case "Animal": //Animal
                this.tagHashMap.put(0, Tag.Animal);
                break;
            case "Tutorial": //Tutorial
                this.tagHashMap.put(1, Tag.Tutorial);
                break;
            case "Lifestyle": //Lifestyle
                this.tagHashMap.put(2, Tag.Lifestyle);
                break;
            case "News": //News
                this.tagHashMap.put(3, Tag.News);
                break;
            default:
                System.out.println("No Tag given.");
                break;
        }
    }

    public void deleteTag(String tag){
        switch(tag){
            case "Animal": //Animal
                this.tagHashMap.replace(0, null);
                break;
            case "Tutorial": //Tutorial
                this.tagHashMap.replace(1, null);
                break;
            case "Lifestyle": //Lifestyle
                this.tagHashMap.replace(2, null);
                break;
            case "News": //News
                this.tagHashMap.replace(3, null);
                break;
            default:
                System.out.println("No Tag to delete.");
                break;
        }
        System.out.println("deleted " + tag + " from tag collection");
    }

    public HashMap<Integer, Tag> getTagHashMap() {
        return tagHashMap;
    }
}
