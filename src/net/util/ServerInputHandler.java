package net.util;

import ui.cli.commands.OperatorCommand;

import java.io.DataInputStream;

public class ServerInputHandler {

    DataInputStream dataInputStream;

    public ServerInputHandler(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

        public void handle(){

        try{
            OperatorCommand operatorCommand = new OperatorCommand(dataInputStream.readChar());
        }
            switch (operatorCommand.getOperator()){
                case ":c":
                    System.out.println("Create Produzent(Name) oder Content[Media-Typ][Produzentenname][komaseparierte Tags, einzelnes Komma fue keine][Bitrate][Laenge][[Optionale Parameter]]");
                    if(s.next() == "\\[.*\\]")
                        createUploaderEventHandler.handle(createUploaderEvent);
                    createContentEventHandler.handle(createContentEvent);
                    break;
        }
    }

}
