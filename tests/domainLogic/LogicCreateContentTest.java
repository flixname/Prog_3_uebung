package domainLogic;

import mediaDB.DataImpl;
import mediaDB.Uploader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LogicCreateContentTest {

    @Test
    void createContent1() {

        Uploader uploader = mock(Uploader.class);
        when(uploader.getName()).thenReturn("Omar-S");
        DataImpl data = mock(DataImpl.class);
        when(data.getUploader().getName()).thenReturn(uploader.getName());
        Logic logic = new Logic(100000);

        logic.createContent(data);

        //assertEquals(1,logic.getMapSize());
        //assertEquals("Omar-S",data.getUploader().getName());

    }

    @Test
    void createContent2() {
        DataImpl data = new DataImpl("Audio", "Kool_Keith", "News, Animal", 22, 222);
        Logic logic = new Logic(Long.MAX_VALUE);

        assertEquals(true, logic.createContent(data));
        assertEquals("Kool_Keith",data.getUploader().getName());
        assertEquals("Kool_Keith",logic.getMediaContentMap().get("0").getUploader().getName());
    }

    @Test
    void ifNoProducerExists() {
        Uploader uploader = mock(Uploader.class);
        DataImpl data = mock(DataImpl.class);

        when(data.getUploader().getName()).thenReturn("Model_500");
        when(uploader.getName()).thenReturn("Model_500");

        Logic logic = new Logic(Long.MAX_VALUE);

 fail();
    }

    @Test
    void ifProducerExists(){
        fail();
    }

    @Test
    void ifLogicSizeFull(){
        fail();
    }

}