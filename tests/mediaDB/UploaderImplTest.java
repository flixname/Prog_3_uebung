package mediaDB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UploaderImplTest {

    @Test
    void setUploaderWithDefaultName() {
        Uploader uploader1 = new UploaderImpl();
        Uploader uploader2 = new UploaderImpl();

        System.out.println(uploader1.getName());
        System.out.println(uploader2.getName());
    }
}