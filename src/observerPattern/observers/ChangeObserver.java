package observerPattern.observers;

import mediaDB.AudioImpl;

import java.util.Observable;
import java.util.Observer;

public class ChangeObserver implements Observer {

    private AudioImpl audio;
    private long lastValue;

    public ChangeObserver(AudioImpl audio, long lastValue) {
        this.audio = audio;
        this.lastValue = lastValue;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.lastValue != audio.getAccessCount()){
            System.out.println("value changed from "+this.lastValue+" to "+this.audio.getAccessCount());
            this.lastValue= this.audio.getAccessCount();
        }else System.out.println("no changes");
    }
}
