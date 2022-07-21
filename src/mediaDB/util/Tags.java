package mediaDB.util;

import mediaDB.Tag;

import java.io.Serializable;
import java.util.HashMap;

public class Tags implements Serializable {

    private HashMap<Integer, Tag> tagHashMap = new HashMap<>();

    public Tags() {
    }

    public Tags(String tags) {
        String[] splitTextContent = tags.split(", ");
        for (String s : splitTextContent) {
            this.addTag(s);
        }
    }

    public boolean addTag(String tag){
        switch(tag){
            case "Animal": //Animal
                this.tagHashMap.put(0, Tag.Animal);
                return true;
            case "Tutorial": //Tutorial
                this.tagHashMap.put(1, Tag.Tutorial);
                return true;
            case "Lifestyle": //Lifestyle
                this.tagHashMap.put(2, Tag.Lifestyle);
                return true;
            case "News": //News
                this.tagHashMap.put(3, Tag.News);
                return true;
            default:
                return false;
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
