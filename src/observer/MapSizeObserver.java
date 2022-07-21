package observer;

import domainLogic.Logic;
import mediaDB.util.Size;

import java.util.Observable;
import java.util.Observer;

public class MapSizeObserver implements Observer {

    private Logic logic;
    private Size oldSize;

    public MapSizeObserver(Logic logic) {
        this.logic = logic;
        this.oldSize = this.logic.getLogicSize().getActualSize();
    }

    @Override
    public void update(Observable o, Object arg) {
     if(this.oldSize.getSize() != this.logic.getLogicSize().getActualSize().getSize()){
         System.out.println("value changed from "+this.oldSize.getSize()+" to "+this.logic.getLogicSize().getActualSize().getSize());
         this.oldSize = this.logic.getLogicSize().getActualSize();
     }else{
         System.out.println("no changes");
     }
    }
}
