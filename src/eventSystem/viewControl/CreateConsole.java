package eventSystem.viewControl;

import eventSystem.infrastructure.CreateAudioEvent;
import eventSystem.infrastructure.CreateAudioEventHandler;
import eventSystem.util.Command;

import java.util.Scanner;

public class CreateConsole {

    private CreateAudioEventHandler createAudioEventHandler;

    public void setCreateEventHandler(CreateAudioEventHandler createAudioEventHandler) {
        this.createAudioEventHandler = createAudioEventHandler;
    }

    public void execute(){
        try(Scanner s = new Scanner(System.in)){
            do{
                System.out.println("Create Console, command with 'c':");
                Command c = new Command(s.next());
                CreateAudioEvent event = new CreateAudioEvent(this);
                switch (c.operator){
                    case CREATEAUDIO:
                        if(this.createAudioEventHandler != null)
                            createAudioEventHandler.handle(event);
                        System.out.println("Audio done!");
                        break;
                    case CREATEVIDEO:
                        if(this.createAudioEventHandler != null)
                            createAudioEventHandler.handle(event);
                        System.out.println("Video done!");
                    case ERROR:
                        System.out.println("error");
                        break;
                }
            }while(true);
        }
    }
}
