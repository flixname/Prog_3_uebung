package ui.cli;

import domainLogic.GLContentImpl;
import mediaDB.Audio;
import mediaDB.AudioImpl;
import mediaDB.Content;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test //Ctest um die funktionalität von command zu prüfen
    void goodCommand1() {
        String testString = "[Audio][Felix][News][200][300]";
        Command command = new Command(testString);

        Assertions.assertEquals("c",command);
        Assertions.assertEquals(0,command.number);
        Assertions.assertEquals("Audio",command.content);
        Assertions.assertEquals("Felix",command.uploader);
        Assertions.assertEquals(200,command.bitrate);
        Assertions.assertEquals(300,command.duration);
        Assertions.assertEquals("News",command.tags.get(0));

    }

    @Test //Ctest um die funktionalität von command zu prüfen mit erstellung audio
    void goodCommand2() {
        String testString = "c,0,Audio,Felix,200,300,News";
        Command command = new Command(testString);

        GLContentImpl testGL = new GLContentImpl();


        LinkedList<Content> tmp = testGL.createContent(
                command.content,
                command.uploader,
                command.bitrate,
                command.duration,
                command.tags);



        Assertions.assertEquals(1, tmp.size());
        Assertions.assertEquals("0", tmp.get(0).getAddress());
    }
}