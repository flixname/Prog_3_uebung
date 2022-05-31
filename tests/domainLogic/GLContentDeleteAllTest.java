package domainLogic;


import mediaDB.AudioVideo;

import mediaDB.Content;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GLContentDeleteAllTest {

    @Test
    void goodDeleteAll1() {

        List<String> testTagCollection = new LinkedList<>();
        testTagCollection.add("Animal");
        GLContentImpl testGLContent1 = new GLContentImpl();

        LinkedList<Content> testList1 = testGLContent1.createContent("Audio", "Felix", 9000, 20042, "News");

        testVerwaltung.create(1, testContent1);
        testVerwaltung.create(2, testContent2);
        testVerwaltung.create(3, testContent3);

        testVerwaltung.deleteAll(); //cause

        assertThrows(NullPointerException.class,
                ()->{
                    mediaDB.AudioVideo temp = testVerwaltung.read(1);
                });
        fail();
    }
}