package domainLogic;

import mediaDB.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerwaltungImpl implements Verwaltung {


    HashMap<Integer, ? super Content> audioVideoHashMap = new HashMap<>();
    ArrayList<Uploader> uploaderArrayList = new ArrayList<>();
    private int dataNr;  //für die vergabe der ZahlenID

    @Override
    public void create(Content data) {
        this.audioVideoHashMap.put(this.dataNr++, data); //dataNr bei Hashmap erhöhen pro create (evtl besser mit hascode)
    }

    @Override
    public HashMap<Integer,? super Content> read() {
        //TODO: Auslesen von was???
            return this.audioVideoHashMap;
    }

    @Override //dinge die printed werden sollen in die Funktion???
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


    @Override //TODO:
    public long update(Integer dataNr) {
        //return this.audioVideoHashMap.get(dataNr) wtf...warum geht das nicht mit dem <? super Content> zusammen ich leite doch von Content ab
        return this.audioVideoHashMap.get(dataNr).
    }

    @Override
    public void delete(Integer dataNr) {
        if (this.audioVideoHashMap.get(dataNr) != null) {
            this.audioVideoHashMap.remove(dataNr);
        } else {
            return;
        }
    }

    @Override //y/n in console
    public void deleteAll() throws NullPointerException {
        this.audioVideoHashMap.clear();
    }

    @Override //muss gemacht werden
    public void createUploader(Uploader name) {
        //TODO: uploader mit in create und update als parameter mitgeben oder gesondert möglicherweise auch als zweites interface und schon zu beginn direkt als uploader???
        this.uploaderArrayList.add(name);
    }
}
