package eventSystem.infrastructure;

import java.util.EventObject;

public class UpdateSingleAccessCountEvent extends EventObject {

    private String address;

    public UpdateSingleAccessCountEvent(Object source, String address) {
        super(source);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
