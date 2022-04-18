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

        AudioVideo testContent1 = new AudioVideoImpl();
        AudioVideo testContent2 = new AudioVideoImpl();
        AudioVideo testContent3 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);
        testVerwaltung.create(2, testContent2);
        testVerwaltung.create(3, testContent3);

        AudioVideo temp = testVerwaltung.read(3); //cause
        Assert.assertEquals(testContent3, temp);
    }

    @Test( )//lese aus db an stelle wo keine Data ist
    void badRead1() throws NullPointerException {
        assertThrows(NullPointerException.class,
                ()->{
                    Verwaltung testVerwaltung = new VerwaltungImpl();

                    AudioVideo temp = testVerwaltung.read(1);
                    Assert.assertEquals(null, temp);
                });
    }


}
