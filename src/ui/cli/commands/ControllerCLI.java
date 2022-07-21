package ui.cli.commands;

import eventSystem.infrastructure.CreateUploaderEvent;
import eventSystem.infrastructure.*;
import ui.cli.commands.CreateContentCommand;
import ui.cli.commands.OperatorCommand;
import ui.cli.commands.CreateUploaderCommand;
import ui.cli.commands.AddressCommand;

import java.util.Scanner;

public class ControllerCLI {

    private OperatorCommand operatorCommand;
    private CreateUploaderCommand createUploaderCommand;
    private CreateContentCommand createContentCommand;
    private AddressCommand addressCommand;

    private CreateUploaderEventHandler createUploaderEventHandler = new CreateUploaderEventHandler();
    private CreateContentEventHandler createContentEventHandler = new CreateContentEventHandler();
    private ReadDiverseContentEventHandler readDiverseContentEventHandler;
    private UpdateCounterEventHandler updateCounterEventHandler = new UpdateCounterEventHandler();
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
                System.out.println("Console operator: :c, :r, :u, :d, :p, :e");

                    this.operatorCommand = new OperatorCommand(s.next());

                //ExitEvent exitEvent = new ExitEvent(this);
                switch (this.operatorCommand.getOperator()){
                    case ":c":
                        System.out.println("Create [Produzentenname] oder Content[Media-Typ][Produzentenname][komaseparierte Tags, einzelnes Komma fuer keine][Bitrate][Laenge][[Optionale Parameter]]");
                        String tmp = s.next();
                        if(tmp.equals("\\[.*\\].*")){
                            this.createContentCommand = new CreateContentCommand(tmp);
                            CreateContentEvent createContentEvent = new CreateContentEvent(this, this.createContentCommand.getContent(),
                                    createContentCommand.getUploader(), createContentCommand.getTags(), createContentCommand.getBitrate(), createContentCommand.getDuration());
                            createContentEventHandler.handle(createContentEvent);
                        }else{
                           createUploaderCommand = new CreateUploaderCommand(tmp);
                           CreateUploaderEvent createUploaderEvent = new CreateUploaderEvent(this, createUploaderCommand.getUploader());
                           createUploaderEventHandler.handle(createUploaderEvent);
                        }
                        break;
                    case ":r": //TODO
                        if(this.readDiverseContentEventHandler != null)
                            //ReadDiverseContentEvent readDiverseContentEvent = new ReadDiverseContentEvent(this, ); //TODO Eventhandlersystem
                           // readDiverseContentEventHandler.handle(readDiverseContentEvent);
                        break;
                    case ":u":
                        System.out.println("Which address would you like to update?: ");
                        if(this.updateCounterEventHandler != null)
                            this.addressCommand = new AddressCommand(s.next());
                            UpdateCounterEvent updateCounterEvent = new UpdateCounterEvent(this, this.addressCommand.getAddress());
                            updateCounterEventHandler.handle(updateCounterEvent);
                        break;
                    case ":d":
                        if(this.deleteSingleEventHandler != null)
                            addressCommand = new AddressCommand(s.next());
                            DeleteSingleContentEvent deleteSingleContentEvent = new DeleteSingleContentEvent(this, addressCommand.getAddress());
                            deleteSingleEventHandler.handle(deleteSingleContentEvent);
                        break;
                    case ":p": //TODO: Persistenz implementieren

//TODO

                        break;
                    case ":e":
                        if(this.exitEventHandler != null)
                            //exitEventHandler.handle(exitEvent);
                        break;
                    default:
                        System.out.println("error, no operator chosen (:c, :r, :u, :d, :p, :e, )");
                        break;
                }
            }while(true);
        }
    }
}
