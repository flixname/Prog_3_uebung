package domainLogic;

import mediaDB.DataImpl;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;
import mediaDB.util.Counter;
import observerPattern.observables.ObservableMapSize;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;


public class MainLogic extends Observable {

    static final long serialVersionUID=1L;

    private UploaderLogic uploaderLogic = new UploaderLogic();
    private ContentLogic contentLogic;

    public MainLogic(long size) {
        this.contentLogic = new ContentLogic(size);
    }  //Map groesse

    public ObservableMapSize getObservableMapSize() {
        return contentLogic.getObservableMapSize();
    }

    public void createContent(String mediaType, String uploaderName, String tags, int bitrate, long laenge) {
        this.contentLogic.createContent(mediaType, uploaderName, tags, bitrate, laenge);
    }

    public boolean update(String address){
            return this.contentLogic.update(address);
    }

    /**
     * @return liefert alle produzenten mit der Anzahl(Zahl) ihrer Contents
     */
    public Map<Uploader, Long> readUploader() {
        Map<Uploader, Long> tmpMap = new HashMap<>();
        Counter counter = new Counter();
        counter.increment();
        for (Uploader listElement : this.uploaderLogic.getUploaderLinkedList()) {
            for (Map.Entry<String, DataImpl> entry : this.contentLogic.getMediaContentMap().entrySet()) {
                if (entry.getValue().getUploader().equals(listElement.getName())) {
                    counter.increment();
                }
            }
            tmpMap.put(listElement, counter.getCounter());
        }
        return tmpMap;
    }

    /**
     * creates an uploader (Anlegen von Produzenten)
     * @param name der zu erstellende Name eine Uploaders
     */
    public boolean createUploader(String name){
        for (Map.Entry<String, DataImpl> entry : this.contentLogic.getMediaContentMap().entrySet()) {
            if (entry.getValue().getUploader().getName().equals(name)) {
                this.uploaderLogic.createUploader(new UploaderImpl(name));
                return true;
            }
        }
        return false;
    }

    /**
     * Löscht einen Uploader, Files bleiben in der mediaContentMap bestehen
     * @param name the uploader name to be deleted
     */
    public boolean deleteUploader(String name){
        Uploader uploader = new UploaderImpl(name);
        for (Uploader listElement : this.uploaderLogic.getUploaderLinkedList()) {
            if (listElement.equals(uploader)) {
                this.uploaderLogic.deleteUploader(uploader);
                return true;
            }
        }
        return false;
    }

    ///////
    //JOS//
    ///////
    public boolean saveJOS(){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("File.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            return true;
        } catch (FileNotFoundException e) { //JBD: hier Encoder
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loadJOS(String file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            UploaderLogic uploaderLogic = (UploaderLogic)objectInputStream.readObject();
            objectInputStream.close();
            this.uploaderLogic = uploaderLogic;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    ///////
    //JBP//
    ///////
    private File xmlFile = new File("JavaBeans.xml");

    public boolean saveToXML(){
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("JavaBeans.xml")));){
            encoder.writeObject(this);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean loadFromXML(){
        try ( XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(
                new FileInputStream("JavaBeans.xml")));){
            List<UploaderLogic> loadedList=(List<UploaderLogic>)decoder.readObject();
            for (UploaderLogic i:loadedList) System.out.println(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
