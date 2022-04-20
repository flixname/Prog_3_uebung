package verwaltung;

import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerwaltungReadTests {

    @Test( )//lese aus db
    void goodRead1() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideoController testContent1 = new AudioVideoImpl();
        AudioVideoController testContent2 = new AudioVideoImpl();
        AudioVideoController testContent3 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);
        testVerwaltung.create(2, testContent2);
        testVerwaltung.create(3, testContent3);

        AudioVideo temp = testVerwaltung.read(3); //cause
        Assert.assertEquals(testContent3, temp);
    }

    @Test( )//lese aus db an stelle wo keine Data ist
    void badRead1() throws NullPointerException {

        Verwaltung testVerwaltung = new VerwaltungImpl();

        assertThrows(NullPointerException.class,
                ()->{
                    AudioVideo temp = testVerwaltung.read(1);
                });
    }

    @Test( )//lese aus db an stelle wo nix ist
    void badRead2() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideoController testContent1 = new AudioVideoImpl();
        AudioVideoController testContent2 = new AudioVideoImpl();
        AudioVideoController testContent3 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);
        testVerwaltung.create(2, testContent2);
        testVerwaltung.create(3, testContent3);

        assertThrows(NullPointerException.class,
                ()->{
                    AudioVideo temp = testVerwaltung.read(0);
                });
    }

    @Test( )//test für AccessCount in der read funktion
    void goodReadWithAccessCount2() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideoController testContent1 = new AudioVideoImpl();
        testVerwaltung.create(1, testContent1);

        testVerwaltung.read(1);
        testVerwaltung.read(1);

        long temp = testContent1.getAccessCount();
        Assert.assertEquals(2, temp);
    }

    @Test( )//test für AccessCount in der read funktion
    void goodReadWithAccessCount3() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideoController testContent1 = new AudioVideoImpl();
        testVerwaltung.create(1, testContent1);

        testVerwaltung.read(1);

        long temp = testContent1.getAccessCount();
        Assert.assertEquals(1, temp);
    }
}
