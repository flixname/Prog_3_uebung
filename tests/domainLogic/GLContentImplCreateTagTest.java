package domainLogic;

import mediaDB.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GLContentImplCreateTagTest {

    GLContentImpl testGLContent1 = new GLContentImpl();

    @Test //erstelle Content mit Tag Animal
    void goodCreateTag1() {

        testGLContent1.createContent("Audio", "Felix", "Animal", 9000, 20042);

        Assertions.assertEquals(true, testGLContent1.getContentLinkedList().get(0).getTags().contains("Animal"));
        Assertions.assertEquals(1, testGLContent1.getContentLinkedList().size());
    }

    @Test //erstelle Tag Lifestyle in vorhandenem Content
    void goodCreateTag2() {

        testGLContent1.createTag("Lifestyle", "1");

        Assertions.assertEquals(true, testGLContent1.getContentLinkedList().get(0).getTags().contains(Tag.Lifestyle));
        Assertions.assertEquals(1, testGLContent1.getContentLinkedList().size());
    }
}