package model;

import domainLogic.util.Address;
import mediaDB.DataImpl;

import java.io.*;
import java.util.HashMap;
import java.util.Observable;

public class ObservableContentMemory extends Observable implements Serializable {

    static final long serialVersionUID=1L;
    private HashMap<Address, DataImpl> addressMediaContentHashMap = new HashMap<>();

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
