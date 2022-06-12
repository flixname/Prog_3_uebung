package observerPattern.observers;

import mediaDB.MediaContent;
import model.ObservableContentMemory;
import observerPattern.observables.ObservableAddress;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class ContentMemoryObserver implements Observer {
    private ObservableContentMemory observableContentMemory;
    private HashMap<ObservableAddress, MediaContent> oldAddressMediaContentHashMap = new HashMap<>();

    public ContentMemoryObserver(ObservableContentMemory observableContentMemory){
        this.observableContentMemory = observableContentMemory;
        this.oldAddressMediaContentHashMap = this.observableContentMemory.getAddressMediaContentHashMap();
    }


    @Override
    public void update(Observable o, Object arg) {
        if(this.oldAddressMediaContentHashMap != this.observableContentMemory.getAddressMediaContentHashMap()){
            System.out.println("New Data created!");
            this.oldAddressMediaContentHashMap = this.observableContentMemory.getAddressMediaContentHashMap();
        }else{
            System.out.println("No changes!");
        }
    }
}
