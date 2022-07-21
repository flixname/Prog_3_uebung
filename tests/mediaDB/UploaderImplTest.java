package mediaDB;

import domainLogic.Logic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UploaderImplTest {

    @Test
    void setUploader() {
        Uploader uploader = mock(Uploader.class);
        when(uploader.getName()).thenReturn("Omar-S");

        assertEquals("Omar-S", uploader.getName());
    }
}