package eventSystem.infrastructure;

import mediaDB.util.Address;

import java.util.EventObject;

public class UpdateCounterEvent extends EventObject {

    private String address;

    public UpdateCounterEvent(Object source, String address) {
        super(source);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
