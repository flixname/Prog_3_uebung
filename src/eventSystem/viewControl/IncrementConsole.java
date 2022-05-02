package eventSystem.viewControl;

import eventSystem.infrastructure.IncrementEvent;
import eventSystem.infrastructure.IncrementEventHandler;
import eventSystem.util.Command;

import java.util.Scanner;

/**
 * prototype Console
 */
public class IncrementConsole {

        private IncrementEventHandler incrementEventHandler;

        public void setIncrementEventHandler(IncrementEventHandler incrementEventHandler) {
                this.incrementEventHandler = incrementEventHandler;
        }

        public void execute(){
                try(Scanner s = new Scanner(System.in)){
                        do{
                                System.out.println("Update Console, command with (u, e):");
                                Command c = new Command(s.next());
                                MasterConsole masterConsole= new MasterConsole();
                                IncrementEvent event = new IncrementEvent(this, c.number);
                                //IncrementEvent event = new IncrementEvent(this);
                                switch (c.operator){
                                        case UPDATE:
                                                if(this.incrementEventHandler != null)
                                                        incrementEventHandler.handle(event);
                                                System.out.println("Done!");
                                                break;
                                        case EXIT:
                                                masterConsole.execute();
                                                break;
                                        case ERROR:
                                                System.out.println("error");
                                                break;
                                }
                        }while(true);
                }
        }
}