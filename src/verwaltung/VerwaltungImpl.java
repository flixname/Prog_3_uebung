package verwaltung;

import mediaDB.Uploader;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerwaltungImpl implements Verwaltung {


    HashMap<Integer, AudioVideoController> audioVideoHashMap = new HashMap<>();
    ArrayList<Uploader> uploaderArrayList = new ArrayList<>();

    @Override
    public void create(Integer dataNr, AudioVideoController data) throws SameDataExistsException, DataNrOccupiedException {

        if (this.audioVideoHashMap.get(dataNr) == null) { //testet ob null

            for (Map.Entry e : audioVideoHashMap.entrySet()){
                AudioVideoController temp = this.audioVideoHashMap.get(e.getKey()); //warum zeigt es diesen Fehler an?
                    if (data == temp){ //testet ob selbe Datei irgendwo schon einmal da
                        throw new SameDataExistsException("Exists already");
                    }
                }
                this.audioVideoHashMap.put(dataNr, data);
        } else {
            throw new DataNrOccupiedException("Is occupied");
        }
    }

    @Override
    public AudioVideoController read(Integer dataNr) {
        //TODO: Auslesen der Eigenschaften
        if (this.audioVideoHashMap.get(dataNr) != null) {
            this.audioVideoHashMap.get(dataNr).incrementAccessCounter();
            return this.audioVideoHashMap.get(dataNr);
        } else {
            throw new NullPointerException("No Data in this place");
        }
    }

    @Override
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
    //TODO: dinge die printed werden sollen in die Funktion

    @Override
    public void update(Integer dataNr, AudioVideoController update) throws NullPointerException, SameDataExistsException {

        //TODO: Hier ist ein Fehler, soll eigentlich ja eine Eigenschaft updaten
        if (update != this.audioVideoHashMap.get(dataNr)) {
            try {
                this.audioVideoHashMap.replace(dataNr, update);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            throw new SameDataExistsException("Data exists already in this place");
        }

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
