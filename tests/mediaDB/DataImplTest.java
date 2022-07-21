package mediaDB;

import domainLogic.Logic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DataImplTest {

    Logic logic = new Logic(100000000);

    @Test //Ob Addresscounter funktioniert
    void goodGetAddress0() {
        DataImpl data = mock(DataImpl.class);
        when(data.getAddress()).thenReturn("0");

        this.logic.createContent(data);

        verify(data).getAddress();
    }

    @Test //Ob Addresscounter dann auch wirklich weiter zaehlt
    void goodGetAddress1(){
        DataImpl data1 =mock(DataImpl.class);
        DataImpl data2 =mock(DataImpl.class);
        when(data2.getAddress()).thenReturn("2");

        this.logic.createContent(data1);
        this.logic.createContent(data2);
        verify(data2).getAddress();
    }

    @Test
    void getSamplingRate() {
    }

    @Test
    void getAddress() {
    }

    @Test
    void getTags() {
    }

    @Test
    void getAccessCount() {
    }

    @Test
    void getHolder() {
    }

    @Test
    void getBitrate() {
    }

    @Test
    void getLength() {
    }

    @Test
    void getSize() {
    }

    @Test
    void getUploader() {
        DataImpl data = new DataImpl("Audio", "Gucci Mane", "News, Animal", 22, 222);

        Assertions.assertEquals("Gucci Mane", data.getUploader().getName());
    }

    @Test
    void getUploadDate() {
    }

    @Test
    void getResolution() {
    }
}