package verwaltung;

import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungDeleteTest {

    @Test //löscht eine Data
    void goodDelete1() {
        Verwaltung testVerwaltung = new VerwaltungImpl();

        AudioVideo testContent1 = new AudioVideoImpl();

        testVerwaltung.delete(1); //cause

        AudioVideo temp = testVerwaltung.getIterator().get(0);
        //AudioVideo temp = testVerwaltung.read(1);

        Assertions.assertEquals(null, temp);
        fail(); //TODO null
    }

    @Test //versucht Data zu löschen es gibt aber keine an dem ort
    void badDelete1() {

        assertThrows(NullPointerException.class,
                ()->{
                    Verwaltung testVerwaltung = new VerwaltungImpl();

                    testVerwaltung.delete(1); //cause
                });
    }

}