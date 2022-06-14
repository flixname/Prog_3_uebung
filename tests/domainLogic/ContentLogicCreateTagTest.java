package domainLogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContentLogicCreateTagTest {

    ContentLogic testGLContent1 = new ContentLogic();

    @Test //erstelle Content
    void goodCreateTag1() {

        testGLContent1.createContent("Audio", "Felix", "Animal", 9000, 20042);

        Assertions.assertEquals(true, testGLContent1.getAddressMediaContentHashMap().containsKey("0"));
        Assertions.assertEquals(1, testGLContent1.getAddressMediaContentHashMap().size());
    }
}