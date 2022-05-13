package domainLogic;

import mediaDB.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GLContentImplTest {

    @Test
    void goodCreateTag1() {
        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioWithCounterImpl();
        Uploader testUploader1 = new UploaderImpl();
        testGLContent.createContent(testAudio1, testUploader1);

        testGLContent.createTag("News", 0);

        Collection temp = testGLContent.readByTags(Tag.News);
        Assertions.assertEquals(1, temp.size());
    }
}