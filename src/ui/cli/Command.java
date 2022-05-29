package ui.cli;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command { //evtl über interface ...?

    int number;
    String operator;
    String content;
    String uploader;
    int bitrate;
    long duration;
    List<String> tags = new LinkedList<>();

    private String[] splitTextContent;


    public Command(String text) {

        String regexPattern =
                "[crudpe]," +   //String operatorChar
                        "\\d*," +       //int number(dataNr zb.)
                        ".*," +         //String content
                        ".*," +         //String uploader
                        "\\d*," +       //int bitrate
                        "\\d*," +       //long duration
                        "[.*,]{0,4}";   //String tags (1-4)
        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(text);

        boolean match = matcher.matches();


            this.splitTextContent = text.split("\\,");

            this.operator = this.splitTextContent[0]; //Operator

            try {
                this.number = Integer.parseInt(this.splitTextContent[1]);  //Number (dataNr zb.)
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.number = 0; //falls nix, dann nix
            }

            this.content = this.splitTextContent[2]; //Content

            this.uploader = this.splitTextContent[3]; //Uploader //TODO: Uploader immer mit erstellen

            try {
                this.bitrate = Integer.parseInt(this.splitTextContent[4]); //Bitrate
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.bitrate = 0; //falls nix, dann nix
            }

            try {
                this.duration = Long.parseLong(this.splitTextContent[5]);  //Duration
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.duration = 0; //falls nix, dann nix
            }

            for (int i = 6; i < this.splitTextContent.length; i++) { //Tags
                this.tags.add(this.splitTextContent[i]);
            }

        }
}
