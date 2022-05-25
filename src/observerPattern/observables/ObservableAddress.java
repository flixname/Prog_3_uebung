package observerPattern.observables;

import domainLogic.util.Address;
import observerPattern.observers.AddressObserver;

import java.util.LinkedList;
import java.util.List;

public class ObservableAddress extends Address {
    private List<AddressObserver> observerList = new LinkedList<>();
    public void addObserver(AddressObserver addressObserver) {this.observerList.add(addressObserver);}
    public void removeObserver(AddressObserver addressObserver) {this.observerList.remove(addressObserver); }


    public ObservableAddress(Integer addressCount) {
        super(addressCount);
        this.setChanged();
        this.notifyObservers();
    }
}
