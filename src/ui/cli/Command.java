package ui.cli;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command { //evtl über interface ...?

    Integer number;
    String operator;
    String content;
    String uploader;
    int bitrate;
    long duration;
    List<String> tags = new LinkedList<>();

    private String[] splitTextContent; //length für duration, - 1 für bitrate


    public Command(String text){

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
        if(matcher.matches()){
            this.splitTextContent = text.split("\\,");
        } try {
            this.operator = this.splitTextContent[0]; //Operator

            try {
                this.number = Integer.parseInt(this.splitTextContent[1]);  //Number (dataNr zb.)
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.number = 0; //falls nix, dann nix
            }

            this.content = this.splitTextContent[2]; //Content

            this.uploader = this.splitTextContent[3]; //Uploader //TODO: was wenn kein uploader da, uploader zu uploader (keine doppelten)

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
            };
        } catch (IllegalArgumentException e) {
            System.out.println("noe, that ain´t workin´ mane!");
        } catch (NullPointerException e) {
            System.out.println("no daymn content in this homie!");
        } finally {
            return;
        }

    }
}
