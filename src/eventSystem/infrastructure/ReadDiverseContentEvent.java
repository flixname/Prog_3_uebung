package eventSystem.infrastructure;

import java.util.EventObject;

public class ReadDiverseContentEvent extends EventObject {

    private String type;  //"Audio", "Video", etc...

    public ReadDiverseContentEvent(Object source, String type) {
        super(source);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
