package ui.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UploaderCommand {

    private String uploader;

    public UploaderCommand(String uploader) {

        String regexPattern = ".*";        //String uploader
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(uploader);

        if(matcher.matches()){
            this.uploader = uploader;
        }else{
            System.out.println("please, type a Name");
        }
    }

    public String getUploader() {
        return uploader;
    }
}
