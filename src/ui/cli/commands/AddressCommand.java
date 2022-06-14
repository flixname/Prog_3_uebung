package ui.cli.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressCommand {

    private String address;

    public AddressCommand(String address) {
        String regexPattern = "\\[\\d*\\]";      //int number(dataNr zb.)
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(address);

        if(matcher.matches()){
            this.address = address;
        }else{
            System.out.println("please, type digits");
        }
    }

    public String getAddress() {
        return address;
    }
}
