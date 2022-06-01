package mediaDB;

import domainLogic.GLContentImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudioImplTest {

    GLContentImpl glContent = new GLContentImpl();

    @BeforeEach
    void createAudio(){
        glContent.createContent("Audio", "Felix", "News", 200, 300);
    }

    @Test
    void goodGetAddress1() {
        Assertions.assertEquals("0", glContent.getContentLinkedList().get(0).getAddress());
    }
}