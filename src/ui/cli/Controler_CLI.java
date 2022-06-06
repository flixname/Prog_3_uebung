package ui.cli;

import eventSystem.infrastructure.CreateUploaderEvent;
import eventSystem.infrastructure.*;

import java.util.Scanner;

public class Controler_CLI {

    OperatorCommand operatorCommand;
    UploaderCommand uploaderCommand;
    ContentCommand contentCommand;
    AddressCommand addressCommand;

    private CreateUploaderEventHandler createUploaderEventHandler;
    private CreateContentEventHandler createContentEventHandler;
    private ReadDiverseContentEventHandler readDiverseContentEventHandler;
    private UpdateCounterEventHandler updateCounterEventHandler;
    private DeleteSingleEventHandler deleteSingleEventHandler;
    private ExitEventHandler exitEventHandler;

    public void setCreateUploaderEventHandler(CreateUploaderEventHandler createUploaderEventHandler) {
        this.createUploaderEventHandler = createUploaderEventHandler;
    }
    public void setCreateContentEventHandler(CreateContentEventHandler createContentEventHandler) {
        this.createContentEventHandler = createContentEventHandler;
    }
    public void setReadDiverseContentEventHandler(ReadDiverseContentEventHandler readDiverseContentEventHandler) {
        this.readDiverseContentEventHandler = readDiverseContentEventHandler;
    }
    public void setUpdateSingleAccessCountEventHandler(UpdateCounterEventHandler updateCounterEventHandler) {
        this.updateCounterEventHandler = updateCounterEventHandler;
    }
    public void setDeleteSingleEventHandler(DeleteSingleEventHandler deleteSingleEventHandler) {
        this.deleteSingleEventHandler = deleteSingleEventHandler;
    }
    public void setExitEventHandler(ExitEventHandler exitEventHandler) {
        this.exitEventHandler = exitEventHandler;
    }

    public void execute(){

        try(Scanner s = new Scanner(System.in)){
            do{

                CreateUploaderEvent createUploaderEvent = new CreateUploaderEvent(this, uploaderCommand.getUploader());
                CreateContentEvent createContentEvent = new CreateContentEvent(this, contentCommand.getContent(), contentCommand.getUploader(), contentCommand.getTags(), contentCommand.getBitrate(), contentCommand.getDuration());
                //ReadDiverseContentEvent readDiverseContentEvent = new ReadDiverseContentEvent(this, ); //TODO Eventhandlersystem
                UpdateCounterEvent updateCounterEvent = new UpdateCounterEvent(this, addressCommand.getAddress());
                DeleteSingleContentEvent deleteSingleContentEvent = new DeleteSingleContentEvent(this, addressCommand.getAddress());
                ExitEvent exitEvent= new ExitEvent(this);

                System.out.println("Console operator: c, r, u, d, p, e");
                operatorCommand = new OperatorCommand(s.next());

                switch (operatorCommand.getOperator()){
                    case ":c":
                        System.out.println("Create Produzent(Name) oder Content[Media-Typ][Produzentenname][komaseparierte Tags, einzelnes Komma fue keine][Bitrate][Laenge][[Optionale Parameter]]");
                        if(s.next() == "\\[.*\\]")
                            createUploaderEventHandler.handle(createUploaderEvent);
                            createContentEventHandler.handle(createContentEvent);
                        break;
                    case ":r": //TODO
                        if(this.readDiverseContentEventHandler != null)
                           // readDiverseContentEventHandler.handle(readDiverseContentEvent);
                        break;
                    case ":u":
                        if(this.updateCounterEventHandler != null)
                            updateCounterEventHandler.handle(updateCounterEvent);
                        break;
                    case ":d":
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
                        System.out.println("error, no operator chosen (c, r, u, d, p, e, ");
                        break;
                }
            }while(true);
        }
    }
}
