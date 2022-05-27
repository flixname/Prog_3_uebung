package domainLogic;
import mediaDB.*;
import observerPattern.observers.AddressObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class GLContentImplUpdateTest {

    private List<String> testTagList = new LinkedList<>();

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        this.testTagList.add("Animal");
        this.testTagList.add("News");
        GLContentImpl testGLContent = new GLContentImpl();
        testGLContent.createContent("Audio", "Felix", 2, 2, testTagList);

        long temp = testGLContent.update(0);

        Assertions.assertEquals(1, temp);
    }

    @Test //Counter an einer Datei hochzählen
    void goodUpdate2() {
        this.testTagList.add("Animal");
        this.testTagList.add("News");
        GLContentImpl testGLContent = new GLContentImpl();
        testGLContent.createContent("Audio", "Felix", 2, 2, testTagList);

        testGLContent.update(0);
        testGLContent.update(0);
        long temp = testGLContent.update(0);

        Assertions.assertEquals(3, temp);
    }

    @Test //Counter an einer Datei hochzählen, dann an einer anderen mit Observerbenachrichtigung
    void goodUpdateWithCounterObserver1() {
        this.testTagList.add("Animal");
        this.testTagList.add("News");
        GLContentImpl testGLContent = new GLContentImpl();

        Content content1 = testGLContent.createContent("Audio", "Felix", 2, 2, testTagList);
        Content content2 = testGLContent.createContent("Audio", "Max", 500, 3000, testTagList);

        AddressObserver addressObserver1 = new AddressObserver(content1);
        


        testGLContent.update(0);
        testGLContent.update(1);
        testGLContent.update(0);

        long temp = testGLContent.update(1);



        Assertions.assertEquals(2, temp);
    }


/*
    @Test
    void goodObserverTest1(){
        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();
        Uploader testUploader1 = new UploaderImpl();
        testGLContent.createContent(testAudio1, testUploader1);

        ChangeObserver o1 = new ChangeObserver(testAudio1);
    }
    */
}