package verwaltung;

import mediaDB.AudioVideo;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class VerwaltungImpl implements Verwaltung {


    HashMap<Integer, AudioVideo> audioVideoHashMap = new HashMap<>();

    @Override
    public Map<Integer, AudioVideo> getMap() {
        return this.audioVideoHashMap;
    }

    @Override
    public void create(Integer dataNr, AudioVideo data) throws SameDataExistsException, DataNrOccupiedException {

        //TODO: samedata exists
        if (this.audioVideoHashMap.get(dataNr) == null) {
                for (int i = 0; i < this.audioVideoHashMap.values().size(); i++) {
                    AudioVideo temp = this.audioVideoHashMap.get(i);
                    if (this.audioVideoHashMap.get(dataNr) == temp){
                        throw new SameDataExistsException("Exists already");
                    }
                }
                this.audioVideoHashMap.put(dataNr, data);
        } else {
            throw new DataNrOccupiedException("Is occupied");
        }

    }

    @Override
    public AudioVideo read(Integer dataNr) {

        if (this.audioVideoHashMap.get(dataNr) != null) {
            return this.audioVideoHashMap.get(dataNr);
        } else {
            throw new NullPointerException("No Data in this place");
        }
    }

    @Override
    public String printAll(PrintStream os) throws NullPointerException{

        try {
            for (int i = 0; i < this.audioVideoHashMap.values().size(); i++) { //geht die Hashmap durch
                if(this.audioVideoHashMap.get(i) == null) throw new NullPointerException("An der Stelle" + i + "befindet sich nichts"); //testet ob an der stelle null
                String temp = this.audioVideoHashMap.get(i).toString(); //TODO: Möglichkeit finden mehrere male hintereinander etwas zu returnen... per stream?
                os.println(temp);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public void update(Integer dataNr, AudioVideo update) throws NullPointerException, DataNrOccupiedException {


        if (update != this.audioVideoHashMap.get(dataNr)) {
            try {
                this.audioVideoHashMap.replace(1, update);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            throw new DataNrOccupiedException("Data exists already");
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

    }

    @Override
    public void createUploader() throws UploaderExistsException {

    }
}
