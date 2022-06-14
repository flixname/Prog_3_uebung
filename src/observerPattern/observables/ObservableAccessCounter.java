package observerPattern.observables;

import java.io.Serializable;

public class ObservableAccessCounter extends ObservableCounter {
    public ObservableAccessCounter() {
        super();
        this.increment();
    }
}
