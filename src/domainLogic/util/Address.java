package domainLogic.util;

import java.io.Serializable;

public class Address implements Serializable {

    private final String ADDRESS;

    public Address(Long address){
        this.ADDRESS = address.toString();
    }

    public Address(String address){
        this.ADDRESS = address;
    }

    public String getAddress() {
        return ADDRESS;
    }

}
