package model;

import mediaDB.MediaContent;
import observerPattern.observables.ObservableAddress;

import java.io.*;
import java.util.HashMap;

public class ContentMemory implements Serializable {

    static final long serialVersionUID=1L;
    private HashMap<ObservableAddress, MediaContent> observableAddressDataHashMap = new HashMap<>();

    public boolean saveToFile(){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("File.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            return true;
        } catch (FileNotFoundException e) { //JBD: hier Encoder
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean loadFromFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("File.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectInputStream.readObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
