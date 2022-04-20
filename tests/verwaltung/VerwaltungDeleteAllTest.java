package verwaltung;

import mediaDB.AudioVideo;
import mediaDB.AudioVideoImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungDeleteAllTest {

    @Test
    void goodDeleteAll1() throws DataNrOccupiedException, SameDataExistsException {

        Verwaltung testVerwaltung = new VerwaltungImpl();
        AudioVideoController testContent1 = new AudioVideoImpl();
        AudioVideoController testContent2 = new AudioVideoImpl();
        AudioVideoController testContent3 = new AudioVideoImpl();

        testVerwaltung.create(1, testContent1);
        testVerwaltung.create(2, testContent2);
        testVerwaltung.create(3, testContent3);

        testVerwaltung.deleteAll(); //cause

        assertThrows(NullPointerException.class,
                ()->{
                    AudioVideo temp = testVerwaltung.read(1);
                });
    }
}