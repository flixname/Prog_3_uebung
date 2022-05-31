package eventSystem.infrastructure;

import java.util.EventObject;

public class DeleteSingleContentEvent extends EventObject {

    private String address;

    public DeleteSingleContentEvent(Object source, String address) {
        super(source);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
