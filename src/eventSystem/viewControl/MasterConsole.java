package eventSystem.viewControl;

import eventSystem.infrastructure.*;
import eventSystem.util.Command;

import java.util.Scanner;

public class MasterConsole {

    private CreateEventHandler createEventHandler;
    private ReadEventHandler readEventHandler;
    private IncrementEventHandler incrementEventHandler;
    private DeleteEventHandler deleteEventHandler;
    private ExitEventHandler exitEventHandler;


    public void setCreateEventHandler(CreateEventHandler createEventHandler) { this.createEventHandler = createEventHandler; }
    public void setReadEventHandler(ReadEventHandler readEventHandler) { this.readEventHandler = readEventHandler; }
    public void setIncrementEventHandler(IncrementEventHandler incrementEventHandler) { this.incrementEventHandler = incrementEventHandler; }
    public void setDeleteEventHandler(DeleteEventHandler deleteEventHandler) { this.deleteEventHandler = deleteEventHandler; }
    public void setExitEventHandler(ExitEventHandler exitEventHandler) {
        this.exitEventHandler = exitEventHandler;
    }

    public void execute(){
        try(Scanner s = new Scanner(System.in)){
            do{
                System.out.println("Master Console command with c, r, u, d, p, e:");
                Command c = new Command(s.next());
                //IncrementConsole incrementConsole = new IncrementConsole();
                //CreateConsole createConsole= new CreateConsole();
                //ReadConsole readConsole= new ReadConsole();
                //DeleteConsole deleteConsole= new DeleteConsole();
                CreateEvent createEvent= new CreateEvent(this);
                ReadEvent readEvent= new ReadEvent(this);
                IncrementEvent incrementEvent= new IncrementEvent(this, c.number);
                DeleteEvent deleteEvent= new DeleteEvent(this, c.number);
                ExitEvent exitEvent= new ExitEvent(this);
                switch (c.operator){
                    case CREATE:
                        if(this.createEventHandler != null)
                            createEventHandler.handle(createEvent);
                        break;
                    case READ:
                        if(this.readEventHandler != null)
                            readEventHandler.handle(readEvent);
                        break;
                    case UPDATE:
                        if(this.incrementEventHandler != null)
                            incrementEventHandler.handle(incrementEvent);
                        break;
                    case DELETE:
                        if(this.deleteEventHandler != null)
                            deleteEventHandler.handle(deleteEvent);
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
