package eventSystem.util;

public class Command {
    public enum Operator{ CREATE, CREATEAUDIO, CREATEVIDEO, DELETE, READ, UPDATE, PERSIST, ERROR, EXIT }
    public final Operator operator;
    //public final int number;
    public Command(String text){
        String op=text;
        //int n=0;
        //try { n=Integer.parseInt(text.substring(1)); } catch (NumberFormatException e){ op=""; }
        switch (op){
            case "c":
                this.operator=Operator.CREATE;
                break;
            case "ca":
                this.operator= Operator.CREATEAUDIO;
                break;
            case "cv":
                this.operator= Operator.CREATEVIDEO;
                break;
            case "d":
                this.operator=Operator.DELETE;
                break;
            case "r":
                this.operator=Operator.READ;
                break;
            case "u":
                this.operator=Operator.UPDATE;
                break;
            case "p":
                this.operator=Operator.PERSIST;
                break;
            case "e":
                this.operator= Operator.EXIT;
                break;
            default:
                this.operator=Operator.ERROR;
                break;
        }
        //this.number=n;
    }
}