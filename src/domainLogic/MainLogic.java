package domainLogic;

import java.io.*;

public class MainLogic {

    static final long serialVersionUID=1L;

    private UploaderLogic uploaderLogic = new UploaderLogic();

    //JOS//
    public boolean saveToFile(){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("File.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(uploaderLogic);
            objectOutputStream.close();
            return true;
        } catch (FileNotFoundException e) { //JBD: hier Encoder
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UploaderLogic loadFromFile(String file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            UploaderLogic uploaderLogic = (UploaderLogic)objectInputStream.readObject();
            objectInputStream.close();
            return this.uploaderLogic = uploaderLogic;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}