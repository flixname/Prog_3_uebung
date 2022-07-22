package mediaDB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UploaderImplTest {

    @Test
    void setUploader() {
        Uploader uploader = mock(UploaderImpl.class);
        when(uploader.getName()).thenReturn("Omar-S");

        assertEquals("Omar-S", uploader.getName());
    }

    @Test
    void UploaderDecorator() {
        Uploader uploader = new UploaderStandardBase(mock(UploaderImpl.class));
        when(uploader.getName()).thenReturn("Queen");

        assertEquals("Queen", uploader.getName());
    }
}