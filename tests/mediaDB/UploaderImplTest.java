package mediaDB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UploaderImplTest {

    @Test //simple Uploader class test
    void setUploader() {
        Uploader uploader1 = new UploaderImpl("Hansi");
        Uploader uploader2 = new UploaderImpl("Gerhard");
        Assertions.assertEquals("Hansi", uploader1.getName());
        Assertions.assertEquals("Gerhard", uploader2.getName());
    }
}