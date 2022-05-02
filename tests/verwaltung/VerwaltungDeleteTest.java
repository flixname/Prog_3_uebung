package verwaltung;

import domainLogic.Verwaltung;
import domainLogic.VerwaltungImpl;
import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungDeleteTest {

    @Test //löscht eine Data
    void goodDelete1() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();

        testVerwaltung.create(1,testContent1);
        testVerwaltung.delete(1);

        assertThrows(NullPointerException.class,
                ()->{
                    mediaDB.AudioVideo temp = testVerwaltung.read(1);
                    Assertions.assertEquals(null, temp);
                });
    }

    @Test //versucht Data zu löschen es gibt aber keine an dem ort
    void badDelete1() {

        Verwaltung testVerwaltung = new VerwaltungImpl();

        assertThrows(NullPointerException.class,
                ()->{
                    testVerwaltung.delete(1);
                });
    }
}