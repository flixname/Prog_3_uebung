package eventSystem.viewControl;

import eventSystem.infrastructure.ExitEvent;
import eventSystem.infrastructure.ExitEventHandler;
import eventSystem.infrastructure.IncrementEvent;
import eventSystem.infrastructure.IncrementEventHandler;
import eventSystem.util.Command;

import java.util.Scanner;

public class MasterConsole {

    private ExitEventHandler exitEventHandler;
    private IncrementEventHandler incrementEventHandler;

    public void setExitEventHandler(ExitEventHandler exitEventHandler) {
        this.exitEventHandler = exitEventHandler;
    }
    public void setIncrementEventHandler(IncrementEventHandler incrementEventHandler) { this.incrementEventHandler = incrementEventHandler; }

    public void execute(){
        try(Scanner s = new Scanner(System.in)){
            do{
                System.out.println("Master Console command with c, u, r, d, p, e:");
                Command c = new Command(s.next());
                //IncrementConsole incrementConsole = new IncrementConsole();
                //CreateConsole createConsole= new CreateConsole();
                //ReadConsole readConsole= new ReadConsole();
                //DeleteConsole deleteConsole= new DeleteConsole();
                IncrementEvent incrementEvent= new IncrementEvent(this, c.number);
                ExitEvent exitEvent= new ExitEvent(this);
                switch (c.operator){
                    case CREATE:
                        //createConsole.execute();
                        break;
                    case READ:
                        //readConsole.execute();
                        break;
                    case UPDATE:
                        if(this.incrementEventHandler != null)
                            incrementEventHandler.handle(incrementEvent);
                        break;
                    case DELETE:
                        //deleteConsole.execute();
                        break;
                    case EXIT:
                        if(this.exitEventHandler != null)
                            exitEventHandler.handle(exitEvent);
                        break;
                    case ERROR:
                        System.out.println("error");
                        break;
                }
            }while(true);
        }
    }
}
