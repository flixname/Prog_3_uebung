package eventSystem.infrastructure;

import java.util.EventObject;

public class DeleteEvent extends EventObject {

    private int dataNr;

    public DeleteEvent(Object source, int dataNr) {
        super(source);
        this.dataNr = dataNr;
    }

    public int getDataNr() {
        return dataNr;
    }
}
