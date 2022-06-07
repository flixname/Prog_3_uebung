package mediaDB;

import domainLogic.GLContentImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataImplTest {

    GLContentImpl glContent = new GLContentImpl();

    @BeforeEach
    void createAudio(){
        glContent.createContent("Audio", "Felix", "News", 200, 300);
    }

    @Test //ob addresscounter funzt
    void goodGetAddress0() {
        Assertions.assertEquals("0", glContent.getContentLinkedList().get(0).getAddress());
    }

    @Test //ob funzt bei zwei dateien == 1 (fängt bei 0 an zu zählen damit übereinstimmend mit listennummer
    void goodGetAddress1(){
        glContent.createContent("Audio", "Hansi", "News", 200, 300);
        glContent.createContent("Audio", "Franz", "News", 200, 300);
        Assertions.assertEquals("2", glContent.getContentLinkedList().get(2).getAddress());
    }
}