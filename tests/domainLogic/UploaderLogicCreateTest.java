package domainLogic;

import mediaDB.Uploader;
import mediaDB.UploaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UploaderLogicCreateTest {

    @Test
    void createUploader1() {
        UploaderLogic uploaderLogic = new UploaderLogic();
        Uploader uploader = new UploaderImpl("Weezer");
        uploaderLogic.createUploader(uploader);

        Assertions.assertEquals("Weezer", uploaderLogic.getUploaderLinkedList().contains(uploader));
    }
}