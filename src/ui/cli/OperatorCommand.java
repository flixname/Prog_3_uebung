package ui.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorCommand {

    private String operator;

    public OperatorCommand(String operator) {

        String regexPattern = "[crudpe]";   //char operatorChar
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(operator);

        if(matcher.matches()){
            this.operator = operator;
        }else{
            System.out.println("Not an operator");
        }
    }

    public String getOperator() {
        return operator;
    }
}
