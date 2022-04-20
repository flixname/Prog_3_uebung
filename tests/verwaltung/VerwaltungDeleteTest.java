package verwaltung;

import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungDeleteTest {

    @Test //löscht eine Data
    void goodDelete1() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideoController testContent1 = new AudioVideoImpl();

        testVerwaltung.create(1,testContent1);
        testVerwaltung.delete(1);

        assertThrows(NullPointerException.class,
                ()->{
                    AudioVideo temp = testVerwaltung.read(1);
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