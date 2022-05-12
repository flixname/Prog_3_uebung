package domainLogic;

import mediaDB.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerwaltungReadTests {

    private GLContent testGLContent1;
    private Audio testAudio1;
    private Audio testAudio2;
    private Audio testAudio3;
    private Video testVideo1;
    private Video testVideo2;
    private Video testVideo3;

    @BeforeEach
    void setUp(){

        //GL
        this.testGLContent1 = new GLContentImpl();

        //Audiomaterial
        this.testAudio1 = new AudioWithCounterImpl();
        this.testAudio2 = new AudioWithCounterImpl();
        this.testAudio3 = new AudioWithCounterImpl();

        this.testGLContent1.create(testAudio1);
        this.testGLContent1.create(testAudio2);
        this.testGLContent1.create(testAudio3);

        //Videomaterial
        this.testVideo1 = new VideoWithCounterImpl();
        this.testVideo2 = new VideoWithCounterImpl();
        this.testVideo3 = new VideoWithCounterImpl();

        this.testGLContent1.create(testVideo1);
        this.testGLContent1.create(testVideo2);
        this.testGLContent1.create(testVideo3);
    }

    @Test//gib alle Contenttypen als Liste zurück
    void goodRead1() {
        LinkedList<Content> temp = this.testGLContent1.readAll(0);
        Assert.assertEquals(6, temp.size());
    }

    @Test//gib nur Audio files als Liste zurück (3)
    void goodRead2() {
        LinkedList<Content> temp = this.testGLContent1.readAll(1);
        Assert.assertEquals(3, temp.size());
    }

    @Test//gib nur Vieo files als Liste zurück (3)
    void goodRead3() {
        LinkedList<Content> temp = this.testGLContent1.readAll(2);
        Assert.assertEquals(3, temp.size());
    }

    @Test//gib nur Audio files als Liste zurück (3) schaue ob wirklich Audio
    void goodRead4() {
        LinkedList<Content> temp = this.testGLContent1.readAll(1);
        Assert.assertEquals(this.testAudio1, temp.get(0));
    }

    @Test//gib nur Audio files als Liste zurück (3) schaue ob wirklich Audio an stelle 3
    void goodRead5() {
        LinkedList<Content> temp = this.testGLContent1.readAll(1);
        Assert.assertEquals(this.testAudio3, temp.get(2));
    }

    @Test//gib nur Audio files als Liste zurück (3) schaue ob wirklich Video
    void goodRead6() {
        LinkedList<Content> temp = this.testGLContent1.readAll(2);
        Assert.assertEquals(this.testVideo1, temp.get(0));
    }

    @Test//gib nur Audio files als Liste zurück (3) schaue ob wirklich Audio an stelle 3
    void goodRead7() {
        LinkedList<Content> temp = this.testGLContent1.readAll(2);
        Assert.assertEquals(this.testVideo3, temp.get(2));
    }

    @Test//versuche Content zurück zubekommen obwohl keiner da ist
    void badRead1() {
        this.testGLContent1.delete(5);
        this.testGLContent1.delete(4);
        this.testGLContent1.delete(3);
        this.testGLContent1.delete(2);
        this.testGLContent1.delete(1);
        this.testGLContent1.delete(0);
        LinkedList<Content> temp = this.testGLContent1.readAll(0);
        Assert.assertEquals(0, temp.size());
    }






    /*
    @Test( )//lese aus db an stelle wo keine Data ist
    void badRead1() throws NullPointerException {

        Verwaltung testVerwaltung = new VerwaltungImpl();

        assertThrows(NullPointerException.class,
                ()->{
                    mediaDB.AudioVideo temp = testVerwaltung.read(1);
                });
    }

    @Test( )//lese aus db an stelle wo nix ist
    void badRead2() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();
        AudioVideo testContent2 = new AudioVideoImpl();
        AudioVideo testContent3 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);
        testVerwaltung.create(2, testContent2);
        testVerwaltung.create(3, testContent3);

        assertThrows(NullPointerException.class,
                ()->{
                    mediaDB.AudioVideo temp = testVerwaltung.read(0);
                });
    }

    @Test( )//test für AccessCount in der read funktion
    void goodReadWithAccessCount2() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();
        testVerwaltung.create(1, testContent1);

        testVerwaltung.read(1);
        testVerwaltung.read(1);

        long temp = testContent1.getAccessCount();
        Assert.assertEquals(2, temp);
        fail();
    }

    @Test( )//test für AccessCount in der read funktion
    void goodReadWithAccessCount3() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();
        testVerwaltung.create(1, testContent1);

        testVerwaltung.read(1);

        long temp = testContent1.getAccessCount();
        Assert.assertEquals(1, temp);

        fail();
    }
    */
}
