package observerPattern.observables;

import domainLogic.util.Address;

public class ObservableAddress extends Address {
    public ObservableAddress(Long address) {
        super(address);
    }

    public ObservableAddress(String address) {
        super(address);
    }

}
