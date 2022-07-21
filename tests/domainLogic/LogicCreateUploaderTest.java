package domainLogic;

import mediaDB.DataImpl;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LogicCreateUploaderTest {

    @Test //erstelle Uploader, bekomme true zurueck weil Uploader erstellt werden kann ohne die MediaContentMap
    void createUploader() {
        Uploader uploader = new UploaderImpl("Ho99o9");
        Logic logic = new Logic(0); //size ist 0, weil uploader liste unabhaengig ist von Contentliste

        assertEquals(true, logic.createUploader(uploader));
    }

    @Test //erstelle selben Uploader nochmal, bekomme false zurueck weil schon vorhanden
    void createUploaderTwice() {
        Uploader uploader1 = new UploaderImpl("Slipknot");
        Uploader uploader2 = new UploaderImpl("Slipknot");
        Logic logic = new Logic(2);
        logic.createUploader(uploader1);

        assertEquals(false, logic.createUploader(uploader2));
    }

    @Test //create an uploader, verify the name
    void mocktestToVerifyName(){
        UploaderImpl uploader = mock(UploaderImpl.class);
        when(uploader.getName()).thenReturn("Limp_Bizkit");
        DataImpl data = mock(DataImpl.class);


        Logic logic = new Logic(20000000);
        when(logic.getMediaContentMap().get(0).getUploader().getName()).thenReturn("Limp_Bizkit");

        assertEquals("Limp_Bizkit",uploader.getName());
        assertEquals(true, logic.createUploader(uploader));
        //assertEquals(1, logic.getMediaContentMap().size());
    }
}