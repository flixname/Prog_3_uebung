package domainLogic;

import mediaDB.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GLContentImplDeleteOneTest {

    @Test //löscht eine Audiofile (zugriff über GLContentImpl linked list methoden)
    void goodDelete1() {
        GLContent testGLContent1 = new GLContentImpl();
        Audio testAudio1 = new AudioImpl();
        Uploader testUploader1 = new UploaderImpl("Felix_1");
        testGLContent1.createContent(testAudio1, testUploader1);

        testGLContent1.deleteOne(0);

        int temp = testGLContent1.readByContentType(0).size();
        Assertions.assertEquals(0, temp);
    }

    @Test //löscht eine Audiofile (zugriff über Interface und readAll())<- sollte das überhaupt gehen? Auch wenn es eh nur eine Kopie von der DB LInkedList aus der GL ist?
    void goodDelete2() {
        GLContent testGLContent1 = new GLContentImpl();
        Audio testAudio1 = new AudioImpl();
        Uploader testUploader1 = new UploaderImpl("Felix_1");
        testGLContent1.createContent(testAudio1, testUploader1);

        testGLContent1.deleteOne(0);

        int temp = testGLContent1.readByContentType(1).size(); //dieser zugriff über size()?
        Assertions.assertEquals(0, temp);
    }

    @Test //löscht eine Audiofile an Stelle wo keine ist
    void badDelete1() {
        GLContent testGLContent1 = new GLContentImpl();
        testGLContent1.deleteOne(0);
    }

    @Test //löscht außerhalb der linked Liste (indexoutofbounds) bzw falsche dataNr angabe
    void badDelete2() {
        GLContent testGLContent1 = new GLContentImpl();
        Video testVideo1 = new VideoWithCounterImpl();
        Uploader testUploader1 = new UploaderImpl("Felix_1");
        testGLContent1.createContent(testVideo1, testUploader1);

        testGLContent1.deleteOne(1);
    }
}