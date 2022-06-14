package domainLogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


class ContentLogicCreateFile {

    @Test //Audio Eintrag
    void goodCreateAudio1() {
        ContentLogic contentLogic = new ContentLogic();
        contentLogic.createContent("Audio", "Scatman_John", "Animal", 9000, 20042);
        Assertions.assertEquals(1, contentLogic.getAddressMediaContentHashMap().size());
        Assertions.assertEquals("Scatman_John", contentLogic.getAddressMediaContentHashMap().get("0").getUploader().getName());
    }

    @Test //Video Eintrag
    void goodCreateVideo1() {
        ContentLogic contentLogic = new ContentLogic();
        contentLogic.createContent("Video", "Rednex", "Animal", 9000, 20042);
        Assertions.assertEquals(1, contentLogic.getAddressMediaContentHashMap().size());
        Assertions.assertEquals("Rednex", contentLogic.getAddressMediaContentHashMap().get("0").getUploader().getName());
    }

    @Test //LicensedAudio Eintrag
    void goodCreateLicensedAudio1() {

        fail();
    }

    @Test //LicensedVideo Eintrag
    void goodCreateLicensedVideo1() {

        fail();
    }
}