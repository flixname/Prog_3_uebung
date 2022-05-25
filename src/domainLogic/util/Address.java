package domainLogic.util;

import java.util.Observable;

public abstract class Address extends Observable {

    private final String address;

    public Address(Integer addressCount){ this.address = addressCount.toString(); }

    public String getAddress() {
        return address;
    }
}
