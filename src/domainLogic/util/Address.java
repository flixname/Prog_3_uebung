package domainLogic.util;

import java.util.Observable;

public abstract class Address {

    private final String ADDRESS;

    public Address(Integer addressCount){ this.ADDRESS = addressCount.toString(); }

    public String getAddress() {
        return ADDRESS;
    }
}
