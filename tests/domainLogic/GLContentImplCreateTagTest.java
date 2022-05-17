package domainLogic;

import mediaDB.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GLContentImplCreateTagTest {

    private ObservableTag observableTag;
    private Address address;
    private ObservableCounter observableCounter;
    private Bitrate bitrate;
    private Laenge laenge;
    private Uploader uploader;

    @Test
    void goodCreateTag1() {
        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioImpl(address, observableTag, observableCounter, bitrate, laenge, uploader);
        Uploader testUploader1 = new UploaderImpl("Felix_1");
        testGLContent.createContent(testAudio1, testUploader1);

        testGLContent.createTag(0, 0);

        Collection temp = testAudio1.getTags();

        Assertions.assertEquals(true, temp.contains(Tag.News));
        fail();
    }
}