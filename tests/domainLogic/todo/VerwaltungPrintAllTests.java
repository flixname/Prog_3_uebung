package domainLogic.todo;

import domainLogic.Verwaltung;
import domainLogic.VerwaltungImpl;
import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.jupiter.api.Test;

class VerwaltungPrintAllTests {


    @Test
    void readAll() throws DataNrOccupiedException, SameDataExistsException {
        Verwaltung testVerwaltung = new VerwaltungImpl();

        AudioVideo testContent1 = new AudioVideoImpl();
        AudioVideo testContent2 = new AudioVideoImpl();
        AudioVideo testContent3 = new AudioVideoImpl();

        testVerwaltung.create(0, testContent1);
        testVerwaltung.create(1, testContent2);
        testVerwaltung.create(2, testContent3);

        testVerwaltung.printAll(System.out); //TODO: was er im speziellen dann überhaupt ausdruckt
    }
}