package ui.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentCommand {

    //int number;
    //String operator;
    private String content;
    private String uploader;
    private String tags;
    private int bitrate;
    private long duration;

    public String getContent() {
        return content;
    }

    public String getUploader() {
        return uploader;
    }

    public String getTags() {
        return tags;
    }

    public int getBitrate() {
        return bitrate;
    }

    public long getDuration() {
        return duration;
    }

    private String[] splitTextContent;

    public ContentCommand(String text) {
        String regexPattern =
                    //":c|:r|:u|:d|:p|:e" +   //String operatorChar
                "\\[.*\\]" +           //String content
                "\\[.*\\]" +            //String uploader
                "\\[[.*,]{0,4}\\]" +    //String tags (1-4);
                "\\[\\d*\\]" +          //int bitrate
                "\\[\\d*\\]";           //long duration
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher operator = pattern.matcher(text);

        if(operator.matches()){
            this.splitTextContent = text.split(text.substring(text.indexOf('[') + 1, text.indexOf(']') - 1));
        }

        //  this.operator = this.splitTextContent[0]; //Operator

            this.content = this.splitTextContent[0]; //Content

            this.uploader = this.splitTextContent[1]; //Uploader
        /*
            try {
                this.number = Integer.parseInt(this.splitTextContent[3]);  //Number (dataNr zb.)
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.number = 0; //falls nix, dann nix
            }
        */

            this.tags = splitTextContent[2];

            try {
                this.bitrate = Integer.parseInt(this.splitTextContent[3]); //Bitrate
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bitrate = 0; //falls nix, dann nix
            }

            try {
                this.duration = Long.parseLong(this.splitTextContent[4]);  //Duration
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.duration = 0; //falls nix, dann nix
            }
        }
}
