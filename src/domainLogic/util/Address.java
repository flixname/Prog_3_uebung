package domainLogic.util;

public class Address {

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
