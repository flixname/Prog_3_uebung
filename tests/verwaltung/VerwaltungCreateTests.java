package verwaltung;

import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;


class VerwaltungCreateTests {

    @Test //Eintrag in der db
    void goodCreate1() throws DataNrOccupiedException, SameDataExistsException {
        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1); //cause

        AudioVideo temp = testVerwaltung.read(1);

        Assertions.assertEquals(testContent1,temp);
    }

    @Test //Eintrag an stelle wo schon irgendetwas ist
    void badCreate1() throws DataNrOccupiedException, SameDataExistsException {
        assertThrows(DataNrOccupiedException.class,
                ()->{
                    Verwaltung testVerwaltung = new VerwaltungImpl();

                    AudioVideo testContent1 = new AudioVideoImpl();
                    AudioVideo testContent2 = new AudioVideoImpl();

                    testVerwaltung.create(1, testContent1);
                    testVerwaltung.create(1, testContent2); //cause
                });
    }

    @Test //Eintrag wird mit gleicher Data versucht zu schreiben, es wird geprüft ob irgendwo diese datei schon vorhanden ist
    void badCreate2() throws SameDataExistsException, DataNrOccupiedException{
        assertThrows(SameDataExistsException.class,
                ()->{
                    Verwaltung testVerwaltung = new VerwaltungImpl();

                    AudioVideo testContent1 = new AudioVideoImpl();


                    testVerwaltung.create(1, testContent1);
                    testVerwaltung.create(2, testContent1); //cause
                });
        //fail();
    }

}