package ui.cli;

import eventSystem.infrastructure.*;

import java.util.Scanner;

public class Controler_CLI {

    private CreateContentEventHandler createContentEventHandler;
    private ReadDiverseContentEventHandler readDiverseContentEventHandler;
    private UpdateSingleAccessCountEventHandler updateSingleAccessCountEventHandler;
    private DeleteSingleEventHandler deleteSingleEventHandler;
    private ExitEventHandler exitEventHandler;

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
                System.out.println("Master Console command operation by Operator: c, r, u, d, p, e, ");
                System.out.println("followed by: (dataNr(if needed)),Content,Uploader,Bitrate,Duration,1-4 Tags");
                Command c = new Command(s.next());

                CreateContentEvent createContentEvent = new CreateContentEvent(this, c.content, c.uploader, c.bitrate, c.duration, c.tags);
                ReadDiverseContentEvent readDiverseContentEvent = new ReadDiverseContentEvent(this, c.content);
                UpdateSingleAccessCountEvent updateSingleAccessCountEvent = new UpdateSingleAccessCountEvent(this, c.number);
                DeleteSingleContentEvent deleteSingleContentEvent = new DeleteSingleContentEvent(this, c.number);
                ExitEvent exitEvent= new ExitEvent(this);

                switch (c.operator){
                    case "c":
                        if(this.createContentEventHandler != null)
                            createContentEventHandler.handle(createContentEvent);
                        break;
                    case "r":
                        if(this.readDiverseContentEventHandler != null)
                            readDiverseContentEventHandler.handle(readDiverseContentEvent);
                        break;
                    case "u":
                        if(this.updateSingleAccessCountEventHandler != null)
                            updateSingleAccessCountEventHandler.handle(updateSingleAccessCountEvent);
                        break;
                    case "d":
                        if(this.deleteSingleEventHandler != null)
                            deleteSingleEventHandler.handle(deleteSingleContentEvent);
                        break;
                    /*case "p": //TODO: Persistenz implementieren
                        if(this.persistEventHandler != null)
                            persistEventHandler.handle(persistEvent);
                        break;*/
                    case "e":
                        if(this.exitEventHandler != null)
                            exitEventHandler.handle(exitEvent);
                        break;
                    default:
                        System.out.println("error, no operator choosen (c, r, u, d, p, e, ");
                        break;
                }
            }while(true);
        }
    }
}
