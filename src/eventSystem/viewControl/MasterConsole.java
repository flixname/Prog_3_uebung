package eventSystem.viewControl;

import eventSystem.infrastructure.ExitEvent;
import eventSystem.util.Command;

import java.util.Scanner;

public class MasterConsole {

    public void execute(){
        try(Scanner s = new Scanner(System.in)){
            do{
                System.out.println("Master Console command with c, u, r, d, p:");
                Command c = new Command(s.next());
                IncrementConsole incrementConsole = new IncrementConsole();
                CreateConsole createConsole= new CreateConsole();
                ReadConsole readConsole= new ReadConsole();
                DeleteConsole deleteConsole= new DeleteConsole();
                ExitEvent exitEvent= new ExitEvent(this);
                switch (c.operator){
                    case CREATE:
                        createConsole.execute();
                        break;
                    case READ:
                        //readConsole.execute();
                        break;
                    case UPDATE:
                        incrementConsole.execute();
                        break;
                    case DELETE:
                        //deleteConsole.execute();
                        break;
                    case EXIT:
                        exitEvent.exit();
                        break;
                    case ERROR:
                        System.out.println("error");
                        break;
                }
            }while(true);
        }
    }
}
