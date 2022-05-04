package eventSystem.infrastructure;

import java.util.EventObject;

public class UpdateEvent extends EventObject {

    private int dataNr;

    public UpdateEvent(Object source, int dataNr) {
        super(source);
        this.dataNr = dataNr;
    }

    public int getDataNr() {
        return dataNr;
    }
}
