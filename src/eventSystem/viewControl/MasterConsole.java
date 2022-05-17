package eventSystem.viewControl;

import eventSystem.infrastructure.*;
import domainLogic.Command;

import java.util.Scanner;

public class MasterConsole {

    private CreateContentEventHandler createContentEventHandler;
    private ReadEventHandler readEventHandler;
    private UpdateEventHandler updateEventHandler;
    private DeleteEventHandler deleteEventHandler;
    private ExitEventHandler exitEventHandler;


    public void setCreateEventHandler(CreateContentEventHandler createContentEventHandler) { this.createContentEventHandler = createContentEventHandler; }
    public void setReadEventHandler(ReadEventHandler readEventHandler) { this.readEventHandler = readEventHandler; }
    public void setUpdateEventHandler(UpdateEventHandler updateEventHandler) { this.updateEventHandler = updateEventHandler; }
    public void setDeleteEventHandler(DeleteEventHandler deleteEventHandler) { this.deleteEventHandler = deleteEventHandler; }
    public void setExitEventHandler(ExitEventHandler exitEventHandler) {
        this.exitEventHandler = exitEventHandler;
    }

    public void execute(){
        try(Scanner s = new Scanner(System.in)){
            do{
                System.out.println("Master Console command with c, r, u, d, p, e:");
                Command c = new Command(s.next());
                //UpdateConsole updateConsole = new UpdateConsole();
                //CreateConsole createConsole= new CreateConsole();  --->mit while true auf false setzen zum zurück kommen
                //ReadConsole readConsole= new ReadConsole();
                //DeleteConsole deleteConsole= new DeleteConsole(); --->mit while true auf false setzen zum zurück kommen für producer und content
                CreateEvent createEvent = new CreateEvent(this);
                ReadEvent readEvent= new ReadEvent(this, c.number);
                UpdateEvent updateEvent = new UpdateEvent(this, c.number);
                DeleteEvent deleteEvent= new DeleteEvent(this, c.number);
                ExitEvent exitEvent= new ExitEvent(this);

                switch (c.operator){
                    case CREATE:
                        if(this.createContentEventHandler != null)
                            createContentEventHandler.handle(createEvent);
                        break;
                    case READ:
                        if(this.readEventHandler != null)
                            readEventHandler.handle(readEvent);
                        break;
                    case UPDATE:
                        if(this.updateEventHandler != null)
                            updateEventHandler.handle(updateEvent);
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
