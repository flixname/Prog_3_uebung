package ui.cli;

import observerPattern.observables.ObservableTag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.cli.commands.CreateContentCommand;

class CommandTest {

    @Test //test um die funktionalität von command zu prüfen (simple wg Tags)
    void goodCommand1() {
        CreateContentCommand command = new CreateContentCommand("[Audio][Felix][News][200][300]");

        Assertions.assertEquals("Audio",command.getContent());
        Assertions.assertEquals("Felix",command.getUploader());
        Assertions.assertEquals("News", command.getTags());
        Assertions.assertEquals(200,command.getBitrate());
        Assertions.assertEquals(300,command.getDuration());
    }

    @Test //Mit obevervable tag für seperation und conversion von den Tags
    void goodCommand2() {
        CreateContentCommand command = new CreateContentCommand("[Audio][Felix][News][200][300]");
        ObservableTag observableTag = new ObservableTag(command.getTags());

        //Assertions.assertEquals("News", observableTag.getTagList().get(0));
    }
}