package observerPattern.observables;

import domainLogic.util.Counter;
import observerPattern.Observable;
import observerPattern.Observer;

import java.util.LinkedList;
import java.util.List;


public class ObservableCounter extends Counter implements Observable {
    private List<Observer> observerList = new LinkedList<>();

    public ObservableCounter() {
        super();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observerList){
            observer.update();
        }
    }

    public void increment() {
        super.increment();
        this.notifyObservers();
    }
}
