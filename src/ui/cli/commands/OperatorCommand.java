package ui.cli.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Command checks and creates a valid String vor an operator
 */
public class OperatorCommand {

    private String operator;

    public OperatorCommand(String operator) {

        String regexPattern = ":c|:r|:u|:d|:p|:e";   //char operatorChar
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(operator);

        if(matcher.matches()){
            this.operator = operator;
        }else{
            this.operator = "-1";
            System.out.println("Not an operator");
        }
    }

    public String getOperator() {
        return this.operator;
    }
}
