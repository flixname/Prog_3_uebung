package domainLogic;

import mediaDB.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GLContentCreateTests {

    ////////
    //GOOD//
    ////////

    @Test //Audio Eintrag
    void goodCreate1() {
        GLContent testGLContent1 = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();
        Uploader testUploader1 = new UploaderImpl();
        testGLContent1.createContent(testAudio1, testUploader1);

        Content temp = testGLContent1.readByContentType(0).get(0);
        Assertions.assertEquals(testAudio1, temp);
    }

    @Test //Video Eintrag
    void goodCreate2() {
        GLContent testGLContent1 = new GLContentImpl();
        Video testVideo1 = new VideoWithCounterImpl();
        Uploader testUploader1 = new UploaderImpl();
        testGLContent1.createContent(testVideo1, testUploader1);

        Content temp = testGLContent1.readByContentType(0).get(0);
        Assertions.assertEquals(testVideo1, temp);
    }

    @Test //LicensedAudio Eintrag
    void goodCreate3() {
        GLContent testGLContent1 = new GLContentImpl();
        Uploader testUploader1 = new UploaderImpl();
        LicensedAudio testLicensedAudio1 = new LicensedAudioWithCounterImpl();
        testGLContent1.createContent(testLicensedAudio1, testUploader1);

        Content temp = testGLContent1.readByContentType(0).get(0);
        Assertions.assertEquals(testLicensedAudio1, temp);
    }

    @Test //LicensedVideo Eintrag
    void goodCreate4() {
        GLContent testGLContent = new GLContentImpl();
        Uploader testUploader1 = new UploaderImpl();
        LicensedVideo testLicensedVideo1 = new LicensedVideoWithCounterImpl();
        testGLContent.createContent(testLicensedVideo1, testUploader1);

        Content temp = testGLContent.readByContentType(0).get(0);
        Assertions.assertEquals(testLicensedVideo1, temp);
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