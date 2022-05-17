package domainLogic;

public class Address {

    private final String address;

    public Address(Integer addressCount){
        this.address = addressCount.toString();
    }

    public String getAddress() {
        return address;
    }
}
