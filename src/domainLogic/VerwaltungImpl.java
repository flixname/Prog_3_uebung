package domainLogic;

import mediaDB.AudioVideo;
import mediaDB.Uploader;
import verwaltung.DataNrOccupiedException;
import verwaltung.SameDataExistsException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerwaltungImpl implements Verwaltung {


    HashMap<Integer, AudioVideo> audioVideoHashMap = new HashMap<>();
    ArrayList<Uploader> uploaderArrayList = new ArrayList<>();


    @Override
    public void create(Integer dataNr, AudioVideo data) {

        if (this.audioVideoHashMap.get(dataNr) == null) {
                this.audioVideoHashMap.put(dataNr, data);

        } else {
            return;
        }
    }

    @Override
    public AudioVideo read(Integer dataNr) {
        //TODO: Auslesen der Eigenschaften
        if (this.audioVideoHashMap.get(dataNr) != null) {
            //TODO
            return this.audioVideoHashMap.get(dataNr);
        } else {
            throw new NullPointerException("No Data in this place");
        }
    }

    @Override //TODO: dinge die printed werden sollen in die Funktion
    public String printAll(PrintStream os) throws NullPointerException{

        try {
            //for (int i = 0; i < this.audioVideoHashMap.values().size(); i++) { //geht die Hashmap durch
            for (Map.Entry e : audioVideoHashMap.entrySet()){
                if(this.audioVideoHashMap.get(e.getKey()) == null) throw new NullPointerException("An der Stelle" + this.audioVideoHashMap.get(e.getKey()) + "befindet sich nichts"); //testet ob an der stelle null
                String temp = this.audioVideoHashMap.get(e.getKey()).toString();
                os.println(temp);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    return null;
    }


    @Override //TODO: über event handler und listener
    public void update(Integer dataNr) {

        this.audioVideoHashMap.get(dataNr).getAccessCount();


    }

    @Override
    public void delete(Integer dataNr) throws NullPointerException{
        if (this.audioVideoHashMap.get(dataNr) != null) {
            this.audioVideoHashMap.remove(dataNr);
        } else {
            throw new NullPointerException("No data to delete");
        }
    }

    @Override
    public void deleteAll() throws NullPointerException {
        //TODO: abfrage Y/N
        this.audioVideoHashMap.clear();
    }

    @Override
    public void createUploader(Uploader name) {
        //TODO: uploader mit in create und update als parameter mitgeben oder gesondert möglicherweise auch als zweites interface und schon zu beginn direkt als uploader???
        this.uploaderArrayList.add(name);
    }
}
