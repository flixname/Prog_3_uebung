package eventSystem.infrastructure;

import java.util.EventObject;

public class ReadEvent extends EventObject {

    private int typ;

    public ReadEvent(Object source, int typ) {
        super(source);
        this.typ = typ;
    }

    public int getTyp() {
        return typ;
    }
}
