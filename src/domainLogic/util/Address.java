package domainLogic.util;

public abstract class Address {

    private final String ADDRESS;

    public Address(Long generalAddressAssignment){ this.ADDRESS = generalAddressAssignment.toString(); }

    public String getAddress() {
        return ADDRESS;
    }
}
