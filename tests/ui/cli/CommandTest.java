package ui.cli;

import domainLogic.GLContentImpl;
import mediaDB.Content;
import observerPattern.observables.ObservableTag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test //test um die funktionalität von command zu prüfen (simple wg Tags)
    void goodCommand1() {
        ContentCommand command = new ContentCommand("[Audio][Felix][News][200][300]");

        Assertions.assertEquals("Audio",command.getContent());
        Assertions.assertEquals("Felix",command.getUploader());
        Assertions.assertEquals("News", command.getTags());
        Assertions.assertEquals(200,command.getBitrate());
        Assertions.assertEquals(300,command.getDuration());
    }

    @Test //Mit obevervable tag für seperation und conversion von den Tags
    void goodCommand2() {
        ContentCommand command = new ContentCommand("[Audio][Felix][News][200][300]");
        ObservableTag observableTag = new ObservableTag(command.getTags());

        Assertions.assertEquals("News", observableTag.getTagList().get(0));
    }
}