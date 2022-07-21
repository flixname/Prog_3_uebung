package observer;

import domainLogic.Logic;
import mediaDB.util.AccessCounter;

import java.util.Observable;
import java.util.Observer;

public class AccessCounterObserver implements Observer {
    private Logic logic;
    private long oldState;

    public AccessCounterObserver(Logic logic){
        this.logic = logic;
        this.oldState = this.logic.getAddressCounter().getCounter();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.oldState != this.logic.getAddressCounter().getCounter()){
            System.out.println("value changed from "+this.oldState+" to "+this.logic.getAddressCounter().getCounter());
            this.oldState = this.logic.getAddressCounter().getCounter();
        }
        else {
            System.out.println("no changes");
        }
    }
}
