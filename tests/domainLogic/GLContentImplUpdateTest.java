package domainLogic;
import mediaDB.*;
import observerPattern.observables.ObservableCounter;
import observerPattern.observers.CounterObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class GLContentImplUpdateTest {

    GLContentImpl testGLContent1 = new GLContentImpl();

    @BeforeEach
    void setTestGLContent(){
        testGLContent1.createContent("Audio", "Felix", "Animal", 22, 222);
    }

    @Test //will sehen ob der counter wirklich bei -1 anfängt
    void plainCountertest1() {
        ObservableCounter observableCounter = new ObservableCounter();

        Assertions.assertEquals(0, observableCounter.getCounter());
    }

    @Test
    void counterAtCreate1(){
        Assertions.assertEquals(0, testGLContent1.getContentLinkedList().get(0).getAccessCount());
    }

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        testGLContent1.update("0");

        Assertions.assertEquals(1, testGLContent1.getContentLinkedList().get(0).getAccessCount());
    }

    @Test //Counter an vorhandener Datei hochzählen vorher 1 jetzt 4
    void goodUpdate2() {

        testGLContent1.update("0");
        testGLContent1.update("0");
        testGLContent1.update("0");

        Assertions.assertEquals("3", testGLContent1.getContentLinkedList().get(0).getAccessCount());
    }

    @Test //TODO
    void goodUpdateWithCounterObserver1() {
        ObservableCounter observableCounter = new ObservableCounter();

        CounterObserver o1 = new CounterObserver(observableCounter);
        observableCounter.addObserver(o1);

        testGLContent1.createContent("Audio", "Jade", "Animal", 22, 222);

        //TODO: observertest fertig schreiben ->>nochmal auf den weg zu dem den accesscount reinschauen, es ist nicht der accesscount selber


    }
}