package domainLogic;
import mediaDB.*;
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

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        testGLContent1.update("1");

        Assertions.assertEquals(1, testGLContent1.getContentLinkedList().get(0).getAccessCount());
    }

    @Test //Counter an vorhandener Datei hochzählen vorher 1 jetzt 4
    void goodUpdate2() {

        long tmp = testGLContent1.update("1");
        tmp = testGLContent1.update("1");
        tmp = testGLContent1.update("1");

        Assertions.assertEquals("5", testGLContent1.getContentLinkedList().get(0).getAccessCount());
    }

    @Test
    void goodUpdateWithCounterObserver1() {
        //TODO: Counter an einer Datei hochzählen mit Observer Benachrichtigung
    }
}