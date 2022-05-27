package domainLogic.util;

import java.util.Observable;

public abstract class Address {

    private final String address;

    public Address(Integer addressCount){ this.address = addressCount.toString(); }

    public String getAddress() {
        return address;
    }
}
