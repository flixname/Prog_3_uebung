package domainLogic.util;

import domainLogic.ContentLogic;
import observerPattern.observables.ObservableCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CounterTest {

    ContentLogic testGLContent1 = new ContentLogic();
    ObservableCounter observableCounter;

    @Test
    void getCounter() {
        Assertions.assertEquals(-1, this.observableCounter.getCounter());
    }

    @Test
    void increment() {
        this.observableCounter.increment();
        Assertions.assertEquals(0, this.observableCounter.getCounter());
    }
}