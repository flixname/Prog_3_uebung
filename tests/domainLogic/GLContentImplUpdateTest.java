package domainLogic;

import domainLogic.util.ObservableTag;
import mediaDB.*;
import observerPattern.observers.AddressObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.fail;

class GLContentImplUpdateTest {

    private ObservableTag observableTag = new ObservableTag(Tag.Animal, Tag.News, Tag.Tutorial);

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        GLContentImpl testGLContent = new GLContentImpl();
        testGLContent.createContent("Audio", "Felix", observableTag.getTagCollection(), BigDecimal.valueOf(2), Duration.of(2, ChronoUnit.MILLIS));

        long temp = testGLContent.update(0);

        Assertions.assertEquals(1, temp);
    }

    @Test //Counter an einer Datei hochzählen
    void goodUpdate2() {
        GLContentImpl testGLContent = new GLContentImpl();
        testGLContent.createContent("Audio", "Felix",observableTag.getTagCollection() , BigDecimal.valueOf(2), Duration.of(2, ChronoUnit.MILLIS));

        testGLContent.update(0);
        testGLContent.update(0);
        long temp = testGLContent.update(0);

        Assertions.assertEquals(3, temp);
    }

    @Test //Counter an einer Datei hochzählen, dann an einer anderen mit Observerbenachrichtigung
    void goodUpdateWithCounterObserver1() {
        GLContentImpl testGLContent = new GLContentImpl();

        Content content1 = testGLContent.createContent("Audio", "Heinz", observableTag.getTagCollection() , BigDecimal.valueOf(3), Duration.of(4, ChronoUnit.MILLIS));
        Content content2 = testGLContent.createContent("Audio", "Heinz", observableTag.getTagCollection() , BigDecimal.valueOf(4), Duration.of(5, ChronoUnit.MILLIS));

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