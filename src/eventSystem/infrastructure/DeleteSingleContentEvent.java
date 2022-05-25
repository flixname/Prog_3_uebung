package eventSystem.infrastructure;

import java.util.EventObject;

public class DeleteSingleContentEvent extends EventObject {

    private int dataNr;

    public DeleteSingleContentEvent(Object source, int dataNr) {
        super(source);
        this.dataNr = dataNr;
    }

    public int getDataNr() {
        return dataNr;
    }
}
