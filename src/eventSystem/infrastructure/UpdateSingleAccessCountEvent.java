package eventSystem.infrastructure;

import java.util.EventObject;

public class UpdateSingleAccessCountEvent extends EventObject {

    private int dataNr;

    public UpdateSingleAccessCountEvent(Object source, int dataNr) {
        super(source);
        this.dataNr = dataNr;
    }

    public int getDataNr() {
        return dataNr;
    }
}
