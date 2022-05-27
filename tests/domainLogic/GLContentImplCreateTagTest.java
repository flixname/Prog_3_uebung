package domainLogic;

import mediaDB.Content;
import mediaDB.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class GLContentImplCreateTagTest {

    @Test //erstelle Content, schaue ob der tag korrekt gesetzt wurde über createContent()
    void goodCreateTag1() {

        List<String> testTagCollection = new LinkedList<>();
        testTagCollection.add("Animal");
        GLContentImpl testGLContent1 = new GLContentImpl();

        LinkedList<Content> testList1 = testGLContent1.createContent("Audio", "Felix", 9000, 20042, testTagCollection);
        Assertions.assertEquals(true, testList1.get(0).getTags().contains(Tag.Animal));
        Assertions.assertEquals(1, testList1.get(0).getTags().size());
    }

    @Test //erstelle tag über createTag(), schaue ob der tag korrekt gesetzt wurde
    void goodCreateTag2() {

        List<String> testTagCollection = new LinkedList<>();
        testTagCollection.add("Animal");
        GLContentImpl testGLContent1 = new GLContentImpl();

        testGLContent1.createContent("Audio", "Felix", 9000, 20042, testTagCollection);

        LinkedList<Content> testList1 = testGLContent1.createTag("Lifestyle", 0);
        Assertions.assertEquals(true, testList1.get(0).getTags().contains(Tag.Lifestyle));
        Assertions.assertEquals(2, testList1.get(0).getTags().size());
    }
}