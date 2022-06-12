package model;

import mediaDB.Data;
import mediaDB.MediaContent;
import observerPattern.observables.ObservableAddress;

import java.io.*;
import java.util.HashMap;
import java.util.Observable;

public class ObservableContentMemory extends Observable implements Serializable {

    static final long serialVersionUID=1L;
    private HashMap<ObservableAddress, MediaContent> addressMediaContentHashMap = new HashMap<>();

    public HashMap<ObservableAddress, MediaContent> getAddressMediaContentHashMap() {
        return addressMediaContentHashMap;
    }

    public void addData(ObservableAddress observableAddress, Data data){
        this.addressMediaContentHashMap.put(observableAddress, data);
    }

    public void updateCounter(String address){
        this.addressMediaContentHashMap.get(address).//TODO FUCK u
    }

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
/*
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
*/
}
