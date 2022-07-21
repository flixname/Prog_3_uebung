package mediaDB.util;

import domainLogic.Logic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccessCounterTest {

    Logic logic = new Logic(1);
    AccessCounter accessCounter = new AccessCounter();
    AddressCounter addressCounter = new AddressCounter();
    Counter counter;

    //Unterschiedliche Counter im Test nach initalisierung

    @Test
    void getAccessCounterAfterInit() {
        Assertions.assertEquals(0, this.accessCounter.getCounter());
    }

    @Test
    void getAddressCounterAfterInit() {
        Assertions.assertEquals(-1, this.addressCounter.getCounter());
    }

    @Test
    void getCounterAfterInit() {
        Assertions.assertEquals(-1, this.counter.getCounter());
    }


    //increment auf den verschiedenen Countern
    @Test
    void increment_1() {
        this.accessCounter.increment();
        Assertions.assertEquals(1, this.accessCounter.getCounter());
    }

    @Test
    void increment_2() {
        this.addressCounter.increment();
        Assertions.assertEquals(0, this.addressCounter.getCounter());
    }

    @Test
    void increment_3() {
        this.counter.increment();
        Assertions.assertEquals(0, this.counter.getCounter());
    }

}