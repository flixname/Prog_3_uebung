package eventSystem.infrastructure;

import java.util.EventObject;

public class IncrementEvent extends EventObject {

    private int dataNr;

    public IncrementEvent(Object source, int dataNr) {
        super(source);
        this.dataNr = dataNr;
    }

    public int getDataNr() {
        return dataNr;
    }
}
