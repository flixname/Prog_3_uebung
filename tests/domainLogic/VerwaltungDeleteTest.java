package domainLogic;

import mediaDB.Audio;
import mediaDB.AudioWithCounterImpl;
import mediaDB.Video;
import mediaDB.VideoWithCounterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungDeleteTest {

    @Test //löscht eine Audiofile (zugriff über GLContentImpl linked list methoden)
    void goodDelete1() {
        GLContentImpl testGLContent1 = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();

        testGLContent1.contentLinkedList.add(testAudio1);
        testGLContent1.delete(0);

        int temp = testGLContent1.contentLinkedList.size();
        Assertions.assertEquals(0, temp);
    }

    @Test //löscht eine Audiofile (zugriff über Interface und readAll())<- sollte das überhaupt gehen? Auch wenn es eh nur eine Kopie von der DB LInkedList aus der GL ist?
    void goodDelete2() {
        GLContent testGLContent1 = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();

        testGLContent1.create(testAudio1);
        testGLContent1.delete(0);

        int temp = testGLContent1.readAll(1).size(); //dieser zugriff über size()?
        Assertions.assertEquals(0, temp);
    }

    @Test //löscht eine Audiofile an Stelle wo keine ist
    void badDelete1() {
        GLContent testGLContent1 = new GLContentImpl();
        testGLContent1.delete(0);
    }

    @Test //löscht außerhalb der linked Liste (indexoutofbounds) bzw falsche dataNr angabe
    void badDelete2() {
        GLContentImpl testGLContent1 = new GLContentImpl();
        Video testVideo1 = new VideoWithCounterImpl();
        testGLContent1.contentLinkedList.add(testVideo1);
        testGLContent1.delete(1);
    }
}