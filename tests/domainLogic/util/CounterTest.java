package domainLogic.util;

import domainLogic.GLContentImpl;
import observerPattern.observables.ObservableCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    GLContentImpl testGLContent1 = new GLContentImpl();
    ObservableCounter observableCounter = new ObservableCounter();

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