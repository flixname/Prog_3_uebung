package domainLogic;

import observerPattern.observables.ObservableAccessCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContentLogicUpdateTest {

    ContentLogic testGLContent1 = new ContentLogic();

    @BeforeEach
    void setTestGLContent(){
        testGLContent1.createContent("Audio", "Felix", "Animal", 22, 222);
    }


    @Test //will sehen ob "access"counter generell funktioniert und bei Initialisierung 0 ansonsten -1
    void notInitialisiertCounter1() {
        ObservableAccessCounter observableAccessCounter = new ObservableAccessCounter();
        Assertions.assertEquals(0, observableAccessCounter.getCounter());
    }

    @Test //Counter noch bei 0
    void counterAtCreate1(){
        Assertions.assertEquals(0, testGLContent1.getAddressMediaContentHashMap().get("0").getAccessCount());
    }

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        testGLContent1.update("0");
        Assertions.assertEquals(1, testGLContent1.getAddressMediaContentHashMap().get("0").getAccessCount());
    }

    @Test //Counter an vorhandener Datei hochzählen vorher 0 jetzt 3
    void goodUpdate2() {
        testGLContent1.update("0");
        testGLContent1.update("0");
        testGLContent1.update("0");
        Assertions.assertEquals(3, testGLContent1.getAddressMediaContentHashMap().get("0").getAccessCount());
    }

    @Test //Counter an vorhandener Datei an anderer Adresse hochzählen
    void goodUpdate3() {
        testGLContent1.createContent("Audio", "Jasmin", "News", 22, 222);
        testGLContent1.update("0");
        testGLContent1.update("0");
        testGLContent1.update("0");
        testGLContent1.update("1");
        testGLContent1.update("1");
        Assertions.assertEquals(3, testGLContent1.getAddressMediaContentHashMap().get("0").getAccessCount());
        Assertions.assertEquals(2, testGLContent1.getAddressMediaContentHashMap().get("1").getAccessCount());
    }

}