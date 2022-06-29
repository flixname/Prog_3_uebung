package ui.cli.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Command checks and creates a valid String vor an uploader name
 */
public class CreateUploaderCommand {

    private String uploader;

    public CreateUploaderCommand(String uploader) {

        String regexPattern = "\\[.*\\]";        //String uploader
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(uploader);

        if(matcher.matches()){
            this.uploader = uploader;
        }else{
            this.uploader = "-1";
            System.out.println("please, type a Name");
        }
    }

    public String getUploader() {
        return uploader;
    }
}
