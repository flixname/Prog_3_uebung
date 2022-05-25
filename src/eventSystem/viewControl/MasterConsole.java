package eventSystem.viewControl;

import eventSystem.infrastructure.*;
import eventSystem.viewControl.util.Command;
import mediaDB.Tag;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Scanner;

public class MasterConsole {

    private CreateContentEventHandler createContentEventHandler;
    private ReadDiverseContentEventHandler readDiverseContentEventHandler;
    private UpdateSingleAccessCountEventHandler updateSingleAccessCountEventHandler;
    private DeleteSingleEventHandler deleteSingleEventHandler;
    private ExitEventHandler exitEventHandler;

    private LinkedList<Tag> tagCollection = new LinkedList<>(); //TEST



    public void setCreateEventHandler(CreateContentEventHandler createContentEventHandler) { this.createContentEventHandler = createContentEventHandler; }
    public void setReadEventHandler(ReadDiverseContentEventHandler readDiverseContentEventHandler) { this.readDiverseContentEventHandler = readDiverseContentEventHandler; }
    public void setUpdateEventHandler(UpdateSingleAccessCountEventHandler updateSingleAccessCountEventHandler) { this.updateSingleAccessCountEventHandler = updateSingleAccessCountEventHandler; }
    public void setDeleteEventHandler(DeleteSingleEventHandler deleteSingleEventHandler) { this.deleteSingleEventHandler = deleteSingleEventHandler; }
    public void setExitEventHandler(ExitEventHandler exitEventHandler) {
        this.exitEventHandler = exitEventHandler;
    }

    public void execute(){

        try(Scanner s = new Scanner(System.in)){
            do{
                System.out.println("Master Console command with c, r, u, d, p, e:");
                Command c = new Command(s.next()); //get following characters
                //UpdateConsole updateConsole = new UpdateConsole();
                //CreateConsole createConsole= new CreateConsole();  --->mit while true auf false setzen zum zurück kommen
                //ReadConsole readConsole= new ReadConsole();
                //DeleteConsole deleteConsole= new DeleteConsole(); --->mit while true auf false setzen zum zurück kommen für producer und content
                this.tagCollection.add(Tag.Animal); //TEST
                CreateContentEvent createContentEvent = new CreateContentEvent(this, s.next(), ); //TODO: Regex Pattern
                ReadDiverseContentEvent readDiverseContentEvent = new ReadDiverseContentEvent(this, s.next()); //TODO: Regex Pattern
                UpdateSingleAccessCountEvent updateSingleAccessCountEvent = new UpdateSingleAccessCountEvent(this, c.number);
                DeleteSingleContentEvent deleteSingleContentEvent = new DeleteSingleContentEvent(this, c.number);
                ExitEvent exitEvent= new ExitEvent(this);

                switch (c.operator){
                    case CREATE:
                        if(this.createContentEventHandler != null)
                            createContentEventHandler.handle(createContentEvent);
                        break;
                    case READ:
                        if(this.readDiverseContentEventHandler != null)
                            readDiverseContentEventHandler.handle(readDiverseContentEvent);
                        break;
                    case UPDATE:
                        if(this.updateSingleAccessCountEventHandler != null)
                            updateSingleAccessCountEventHandler.handle(updateSingleAccessCountEvent);
                        break;
                    case DELETE:
                        if(this.deleteSingleEventHandler != null)
                            deleteSingleEventHandler.handle(deleteSingleContentEvent);
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
