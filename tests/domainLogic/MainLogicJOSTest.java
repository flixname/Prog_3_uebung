package domainLogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainLogicJOSTest {

    @Test
    void setup(){
        MainLogic mainLogic = new MainLogic();
        UploaderLogic uploaderLogic = new UploaderLogic();

        ContentLogic contentLogic = new ContentLogic();
        contentLogic.createContent("Audio", "Harald", "Animal", 9000, 20042);
        uploaderLogic.setContentLogic(contentLogic);

        mainLogic.setUploaderLogic(uploaderLogic);

        mainLogic.saveJOS();
    }

    @Test
    void loadFromFile() {
        MainLogic mainLogic = new MainLogic();
        mainLogic.loadJOS("File.txt");

        Assertions.assertEquals(1, mainLogic.getUploaderLogic().getContentLogic().getAddressMediaContentHashMap().size());
        Assertions.assertEquals("Harald", mainLogic.getUploaderLogic().getContentLogic().getAddressMediaContentHashMap().get("0").getUploader().getName());
    }
}