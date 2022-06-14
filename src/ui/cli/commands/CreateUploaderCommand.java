package ui.cli.commands;

import mediaDB.Uploader;
import mediaDB.UploaderImpl;

public class CreateUploaderCommand {

    Uploader uploader;

    public CreateUploaderCommand(String uploader) {
        this.uploader = new UploaderImpl(uploader);
    }
}
