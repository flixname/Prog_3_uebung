package domainLogic;

import domainLogic.GLContent;
import domainLogic.GLContentImpl;
import mediaDB.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.Assert.fail;

class GLContentImplReadByTagsTest {

    @Test
    void readByTags1() {
        GLContent testGLContent = new GLContentImpl();
        Audio testAudio1 = new AudioImpl();
        Audio testAudio2 = new AudioImpl();
        Uploader testUploader1 = new UploaderImpl();
        testGLContent.createContent(testAudio1, testUploader1);
        testGLContent.createContent(testAudio2, testUploader1);


        testGLContent.createTag(0, 0);
        testGLContent.createTag(1, 1);

        LinkedList<Content> temp = testGLContent.readByTags(Tag.News);
        Assertions.assertEquals(1, temp.size());
        fail();
    }

    //AddTags

    //TODO: getTAgs

    //TODO: ob tag schon vergeben/nicht doppelt
}