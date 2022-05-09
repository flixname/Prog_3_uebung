package domainLogic;

import mediaDB.*;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class VerwaltungImpl implements Verwaltung {

    private int dataNr=0;  //für die Vergabe der ZahlenID in der HashMap

    HashMap<Integer, Content> audioVideoHashMap = new HashMap<>();

    @Override
    public void create(AudioVideo data) { //dataNr bei Hashmap erhöhen pro create (evtl besser mit hashcode)
        //TODO: uploader muss eingeben werden (submenue?)
        //TODO: uploader mit in create und update als parameter mitgeben oder gesondert möglicherweise auch als zweites interface und schon zu beginn direkt als uploader???
        this.audioVideoHashMap.put(this.dataNr++, data);
    }

    @Override
    public HashMap<Integer, Content> read() { //Auslesen von was?
        return this.audioVideoHashMap;
    }

    @Override
    public long update(Integer dataNr) {
            return this.audioVideoHashMap.get(dataNr).getAccessCount();
    }  //TODO: Test ob pro data wirklich unterschiedliche counts

    @Override
    public void delete(Integer dataNr) {
            this.audioVideoHashMap.remove(dataNr);
    }

    @Override //dinge die printed werden sollen in die Funktion??? -------> keine print streams hier machen nur werte zurück geben
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

    @Override //y/n in console
    public void deleteAll() throws NullPointerException {
        this.audioVideoHashMap.clear();
    }

    @Override //als seperate methode
    public void createUploader(Integer dataNr, String name) {
        this.audioVideoHashMap.get(dataNr).);
    }
}
