package domainLogic;

import mediaDB.Audio;
import mediaDB.AudioWithCounterImpl;
import mediaDB.Content;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GLContentCreateTests {

    @Test //Audio Eintrag in der Contentliste
    void goodCreate1() {

        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();

        testGLContent.create(testAudio1);
        Content temp = testGLContent.readAll(0).get(0);

        Assertions.assertEquals(testGLContent.readAll(0).get(0), temp);
    }

    @Test //Audio Eintrag erfassen über typ 1 (audio)
    void goodCreate2() {

        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();

        testGLContent.create(testAudio1);
        Content temp = testGLContent.readAll(3).get(0);

        Assertions.assertEquals(testGLContent.readAll(1).get(0), temp);
    }

    @Test
    void goodCreate3() {

        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();

        testGLContent.create(testAudio1);
        int temp = testGLContent.readAll(2).size();  //test um nicht funktionalität nachzuweisen, da in falscher (nichtr vorhandener Liste gesucht wird)

        Assertions.assertEquals(0, temp);
    }

    @Test //verusche video in liste zu finden über typ 2(Video) aber findet nichts weil list nicht mit video befüllt
    void goodCreate4() {

        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();

        testGLContent.create(testAudio1);
        int temp = testGLContent.readAll(2).size();  //test um nicht funktionalität nachzuweisen, da in falscher (nichtr vorhandener Liste gesucht wird)

        Assertions.assertEquals(0, temp);
    }



/*
    @Test //Eintrag an stelle wo schon irgendetwas ist
    void badCreate1() {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();
        AudioVideo testContent2 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);

        assertThrows(DataNrOccupiedException.class,
                ()->{
                    testVerwaltung.create(1, testContent2); //cause
                });
    }

    @Test //Eintrag wird mit gleicher Data versucht zu schreiben, es wird geprüft ob irgendwo diese datei schon vorhanden ist
    void badCreate2(){

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);

        assertThrows(SameDataExistsException.class,
                ()->{
                    testVerwaltung.create(2, testContent1); //cause
                });
    }
 */
}