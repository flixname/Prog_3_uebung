package domainLogic;

import mediaDB.*;

import mediaDB.util.Address;
import mediaDB.util.AddressCounter;
import mediaDB.util.Counter;
import mediaDB.util.LogicSize;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

/**
 * Verwaltung von verschiedenem Content(Audio, Video, etc.)
 */
public class Logic extends Observable implements Serializable {
    static final long serialVersionUID=1L;

    private AddressCounter addressCounter; //Adressvergabe
    public AddressCounter getAddressCounter() {
        return addressCounter;
    }
    public void setAddressCounter(AddressCounter addressCounter) {
        this.addressCounter = addressCounter;
    }

    private Map<String, DataImpl> mediaContentMap; //MediaContent
    public Map<String, DataImpl> getMediaContentMap() {
        return mediaContentMap;
    }
    public void setMediaContentMap(Map<String, DataImpl> mediaContentMap) {
        this.mediaContentMap = mediaContentMap;
    }

    private LogicSize logicSize; //Logic-Groesse
    public LogicSize getLogicSize() {
        return logicSize;
    }
    public void setLogicSize(LogicSize logicSize) {
        this.logicSize = logicSize;
    }

    private List<Uploader> uploaderLinkedList;
    public List<Uploader> getUploaderLinkedList() {
        return uploaderLinkedList;
    }
    public void setUploaderLinkedList(List<Uploader> uploaderLinkedList) {
        this.uploaderLinkedList = uploaderLinkedList;
    }

    public Logic() {
    }

    public Logic(long size) {
        this.logicSize = new LogicSize();
        this.logicSize.setMaxCapacity(size);
        this.addressCounter = new AddressCounter();
        this.mediaContentMap = new HashMap<>();
        this.uploaderLinkedList = new LinkedList<>();
    }

    public Logic reference;

    //----------------------------------------
    //--------------Funktionalitaet-----------
    //----------------------------------------

    /**
     * creates an uploader (Anlegen von Produzenten) es wird sichergestellt, dass kein Uploader mehr als einmal vorkommt
     * @param uploader bekommt einen Uploader in dem der Name des Uploaders steckt als String
     */
    public boolean createUploader(Uploader uploader){
        List<Uploader> tmp = this.uploaderLinkedList;
        if(tmp.size() != 0) {
            for (Uploader entry : tmp) {
                if (entry.getName().equals(uploader.getName())) {
                    return false;
                }
            }
        }
        setUploaderLinkedList(tmp);
        return true;
    }


    /**
     * Hochladen von Mediendateien verschieden Typs, zusammen mit einer Adresse und einem Uploader und anderen Daten(Bitrate etc.)
     * TODO: es ist zu prüfen, dass die Media-Datei zu einem bereits existierenden Produzenten gehört
     */
    public boolean createContent(DataImpl data) {
        Address tmpAddress = new Address(this.addressCounter.getCounter() + 1);  //fuer ueberpruefung ob zukuenftige Adresse vergeben
        if(this.mediaContentMap != null) {
            for (Map.Entry<String, DataImpl> addressMediaContent : this.mediaContentMap.entrySet()) {
                if (addressMediaContent.getValue().getAddress().equals(tmpAddress.getAddress())) { //checke ob Adresse vergeben in den MediaContents
                    return false;
                }
            }
            if (this.logicSize.setActualSize(data.getSize().longValue())) {
                data.setAddress(tmpAddress);
                this.mediaContentMap.put(data.getAddress(), data);
                this.createUploader(data.getUploader());
                this.setChanged();
                this.notifyObservers();
                return true;
            }
        }
        return false;
    }

    /**
     * zählt einen AccessCounter um ++ hoch beim access
     * @param address Nummer der Datei in der mediaContentMap
     */
    public boolean update (String address) {
        for (Map.Entry<String, DataImpl> addressMediaContent : this.mediaContentMap.entrySet()) {
            if (addressMediaContent.getKey().equals(address)) {
                if(addressMediaContent.getValue().getAddress().equals(address)){
                    this.mediaContentMap.get(address).update();
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * @return liefert alle produzenten mit der Anzahl(Zahl) ihrer Contents
     */
    public Map<Uploader, Long> readUploader() {
        Map<Uploader, Long> tmpMap = new HashMap<>();
        Counter counter = null;
        counter.increment();
        if(this.uploaderLinkedList!=null && this.mediaContentMap!=null){
            for (Uploader uploader : this.uploaderLinkedList) {
                for (Map.Entry<String, DataImpl> addressMediaContent : this.mediaContentMap.entrySet()) {
                    if (addressMediaContent.getValue().getUploader().getName().equals(uploader.getName())) {
                        counter.increment();
                    }
                }
                tmpMap.put(uploader, counter.getCounter());
            }
            return tmpMap;
        }
        return null;
    }



    /**
     * Löscht einen Uploader, Files bleiben in der mediaContentMap bestehen, da im Draft nicht weiter definiert
     * @param uploader ist der Uploader der gelöscht werden soll
     */
    public boolean deleteUploader(Uploader uploader) {
        if (this.uploaderLinkedList != null) {
            for (Uploader listElement : this.uploaderLinkedList) {
                if (listElement.getName().equals(uploader.getName())) {
                    this.uploaderLinkedList.remove(listElement);
                    return true;
                }
            }
        }
        return false;
    }

    /*
    /**
     * Weist einen Tag aus den vier gegeben zu (Animal, Tutorial, Lifestyle, News)
     *
     * @param  Name (Animal, Tutorial, Lifestyle, News)
     * @param address position der Mediendatei zu der tag hinzugefügt werden soll
     */
/*
    public boolean createTag(String tag, String address) {

        //TODO
        if (this.observableAddressDataHashMap != null) {
            if (this.observableAddressDataHashMap.containsKey(address)) {
                this.observableAddressDataHashMap.get(address)
            }
            return false;
        }
     */

        public List<DataImpl> readContentByType (String mediaType){

        List tempContentLinkedList = new LinkedList<>();

            switch (mediaType) {
                case "All":
                    if (this.mediaContentMap != null) {
                        for (Map.Entry<String, DataImpl> addressMediaContent : this.mediaContentMap.entrySet()) {
                            tempContentLinkedList.add(addressMediaContent);
                        }
                        return tempContentLinkedList;
                    }
                    break;

                case "Audio":
                    if (this.mediaContentMap  != null) {
                        for (Map.Entry<String, DataImpl> dataEntry : this.mediaContentMap.entrySet()) {
                            if (dataEntry.getValue().getMediaTypeBaseDelegate().equals("Audio")) {
                                tempContentLinkedList.add(dataEntry);
                            }
                        }
                        return tempContentLinkedList;
                    }
                    break;

                case "Video":
                    if (this.mediaContentMap  != null) {
                        for (Map.Entry<String, DataImpl> dataEntry : this.mediaContentMap.entrySet()) {
                            if (dataEntry.getValue().getMediaTypeBaseDelegate().equals("Video")) {
                                tempContentLinkedList.add(dataEntry);
                            }
                        }
                        return tempContentLinkedList;
                    }
                    break;

                default:
                    return null;
            } //TODO: licensed etc
            return tempContentLinkedList;
        }



    /**
     * TODO: Abruf aller vergebenen bzw. nicht vergebenen Tags in der Verwaltung
     * @return Linkedlist of Tags
     */

        public List<Content> readContentByTags (Tag tag) { //TODO: hier ist was falsch generell im Verständnis der methode
            List tmpList = new LinkedList();
            if (this.mediaContentMap != null && this.mediaContentMap.size() > 0) {
                for (Map.Entry<String, DataImpl> addressMediaContent : this.mediaContentMap.entrySet()) {
                    if (addressMediaContent.getValue().getTags().contains(tag)) ;
                            tmpList.add(addressMediaContent.getValue());
                }
                return tmpList;
            }
            return null;
        }

    /**
     * Zum Lesen von Content nach Typ
     * @param "All", "Audio", "Video", etc...
     */
    /*
    public LinkedList<Content> readContentByType(String mediaType){

    }
     */


   // /**
    // * TODO: Löschen einer bestimmten Mediadatei
     //* @param address Addresse (zahl) der zu löschenden Datei in DB LinkedList
     //*/
/*
        public boolean deleteSingleContent (String address){
            if (this.observableAddressDataHashMap != null && this.observableAddressDataHashMap.size() > Integer.parseInt(address)) {
                for (Data listElement : this.observableAddressDataHashMap) {
                    if (listElement.getAddress() == address) {
                        this.observableAddressDataHashMap.remove(listElement);
                        return true;
                    }
                }
            }
            return false;
        }
    }

 */

    ///////
    //JOS//
    ///////
    public boolean saveJOS(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("File.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.addressCounter);
            objectOutputStream.writeObject(this.logicSize);
            objectOutputStream.writeObject(this.mediaContentMap);
            objectOutputStream.writeObject(this.uploaderLinkedList);
            objectOutputStream.close();
            return true;
        } catch (FileNotFoundException e) { //JBD: hier Encoder
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loadJOS(){
        try {
            FileInputStream fileInputStream = new FileInputStream("File.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AddressCounter addressCounter = (AddressCounter) objectInputStream.readObject();
            LogicSize logicSize = (LogicSize) objectInputStream.readObject();
            Map mediaContentMap = (Map) objectInputStream.readObject();
            List uploaderLinkedList = (List) objectInputStream.readObject();
            objectInputStream.close();
            this.addressCounter = addressCounter;
            this.logicSize = logicSize;
            this.mediaContentMap = mediaContentMap;
            this.uploaderLinkedList = uploaderLinkedList;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    ///////TODO
    //JBP//
    ///////
    private File xmlFile = new File("JavaBeans.xml");

    public void saveToXML(){
        int cnt=1;
        ArrayList<Logic> items = new ArrayList<>(cnt);
        for (int i=1;i<=cnt;i++){
            Logic logicTmp = new Logic();
            logicTmp.setAddressCounter(this.addressCounter);
            logicTmp.setMediaContentMap(this.mediaContentMap);
            logicTmp.setLogicSize(this.logicSize);
            logicTmp.setUploaderLinkedList(this.uploaderLinkedList);
            items.add(logicTmp);
        }
        for (int i=0;i<cnt;i++) items.get(i).reference=items.get((i+cnt-1)%cnt);
        for (Logic i:items)
            System.out.println(i);
        System.out.println("---");

        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("JavaBeans.xml")));){
            encoder.writeObject(items);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadFromXML(){ //TODO: boolean test
        try ( XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("JavaBeans.xml")));){
            ArrayList<Logic> loadedList = (ArrayList<Logic>)decoder.readObject();
            for (Logic i:loadedList){
                System.out.println(i);

                this.setAddressCounter(i.getAddressCounter());
                this.setLogicSize(i.getLogicSize());
                this.setUploaderLinkedList(i.getUploaderLinkedList());
                this.setMediaContentMap(i.getMediaContentMap());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
