package domainLogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UploaderLogicCreateTest {

    @Test
    void createUploader1() {
        UploaderLogic uploaderLogic = new UploaderLogic();
        uploaderLogic.createUploader("Morbido");


        Assertions.assertEquals(1, uploaderLogic.getUploaderLinkedList().size());
    }
}