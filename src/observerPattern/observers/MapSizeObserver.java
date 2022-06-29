package observerPattern.observers;

import mediaDB.util.Size;
import observerPattern.observables.ObservableMapSize;

import java.util.Observable;
import java.util.Observer;

public class MapSizeObserver implements Observer {

    private ObservableMapSize observableMapSize;
    private Size oldSize;

    public MapSizeObserver(ObservableMapSize observableMapSize) {
        this.observableMapSize = observableMapSize;
        this.oldSize = this.observableMapSize.getSize();
    }

    @Override
    public void update(Observable o, Object arg) {
     if(this.oldSize.getSize() != this.observableMapSize.getSize().getSize()){
         System.out.println("value changed from "+this.oldSize.getSize()+" to "+this.observableMapSize.getSize().getSize());
         this.oldSize = this.observableMapSize.getSize();
     }else{
         System.out.println("no changes");
     }
    }
}
