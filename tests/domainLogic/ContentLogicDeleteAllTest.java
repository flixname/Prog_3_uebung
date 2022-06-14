package domainLogic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class ContentLogicDeleteAllTest {

    ContentLogic testGLContent1 = new ContentLogic();

    @Test
    void goodDeleteAll1() {

        testGLContent1.createContent("Audio", "Felix", "News", 20042, 9000);
        testGLContent1.createContent("Audio", "Hansi", "News", 365, 666);

        //testGLContent1.deleteSingleContent("1");

        //Assertions.assertEquals(1, testGLContent1.getContentLinkedList().size());
        fail();
    }
}