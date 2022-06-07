package domainLogic;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GLContentDeleteAllTest {

    GLContentImpl testGLContent1 = new GLContentImpl();

    @Test
    void goodDeleteAll1() {

        testGLContent1.createContent("Audio", "Felix", "News", 20042, 9000);
        testGLContent1.createContent("Audio", "Hansi", "News", 365, 666);

        testGLContent1.deleteSingleContent("1"); //cause

        Assertions.assertEquals(1, testGLContent1.getContentLinkedList().size());
    }
}