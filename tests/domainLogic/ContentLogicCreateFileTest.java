package domainLogic;

import mediaDB.DataImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.fail;


class ContentLogicCreateFileTest {

    @Test //Audio Eintrag
    void goodCreateAudio1() {
        DataImpl data = mock(DataImpl.class);
        ContentLogic contentLogic = new ContentLogic();

        Assertions.assertEquals(1, contentLogic.getMediaContentMap().size());
    }

    @Test //Video Eintrag
    void goodCreateVideo1() {
        ContentLogic contentLogic = new ContentLogic();
        contentLogic.createContent("Video", "Rednex", "Animal", 9000, 20042);
        Assertions.assertEquals(1, contentLogic.getMediaContentMap().size());
        Assertions.assertEquals("Rednex", contentLogic.getMediaContentMap().get("0").getUploader().getName());
    }

    @Test //LicensedAudio Eintrag
    void goodCreateLicensedAudio1() {

        fail();
    }

    @Test //LicensedVideo Eintrag
    void goodCreateLicensedVideo1() {

        fail();
    }

    @Test //check ob size funktioniert
    void sizeCheck1() {
        ContentLogic contentLogic = new ContentLogic();
        contentLogic.createContent("Audio", "Rednex", "Animal", 1000, 100);
        Assertions.assertEquals(1100, contentLogic.getMediaContentMap().get("0").getSize());
    }
}