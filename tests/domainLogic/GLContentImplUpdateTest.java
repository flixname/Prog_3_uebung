package domainLogic;

import mediaDB.Audio;
import mediaDB.AudioImpl;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GLContentImplUpdateTest {

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioImpl();
        Uploader testUploader1 = new UploaderImpl("Metallica");
        testGLContent.createContent(testAudio1, testUploader1);

        testGLContent.update(0);
        long temp = testGLContent.update(0);

        Assertions.assertEquals(2, temp);
    }

    @Test
    void goodMultipleUpdate1() {
        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioImpl();
        Audio testAudio2= new AudioImpl();
        Uploader testUploader1 = new UploaderImpl("Sepultura");
        testGLContent.createContent(testAudio1, testUploader1);
        testGLContent.createContent(testAudio2, testUploader1);

        testGLContent.update(1);
        long temp2 = testGLContent.update(1);

        long temp1 = testGLContent.update(0);

        Assertions.assertEquals(1, temp1);
        Assertions.assertEquals(2, temp2);
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