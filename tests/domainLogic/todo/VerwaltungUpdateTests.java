package domainLogic.todo;

import domainLogic.Verwaltung;
import domainLogic.VerwaltungImpl;
import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungUpdateTests {

    @Test //update mit anderem: testContent4
    void goodUpdate1() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();
        AudioVideo testContent4 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);
        //testVerwaltung.update(1, testContent4);

        mediaDB.AudioVideo temp = testVerwaltung.read(1);
        Assertions.assertEquals(testContent4, temp);
    }

    @Test //update mit gleichem content: testContent1
    void badUpdate1() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideo testContent1 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);

        assertThrows(SameDataExistsException.class,
                ()->{
                    //testVerwaltung.update(1, testContent1); //cause
                });
    }
}