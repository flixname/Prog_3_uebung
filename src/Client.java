import domainLogic.Logic;
import eventSystem.infrastructure.CreateContentEventHandler;
import eventSystem.infrastructure.CreateContentEventListener;
import eventSystem.listener.CreateContentEventListenerImpl;
import ui.cli.commands.ControllerCLI;

import java.io.*;
import java.net.Socket;

public class Client  {
    //thread?

    public static void main(String[] args) {

        Logic logic = new Logic(Long.MAX_VALUE);
        ControllerCLI controllerCLI = new ControllerCLI();

        CreateContentEventHandler createContentEventHandler = new CreateContentEventHandler();
        CreateContentEventListener createContentEventListener = new CreateContentEventListenerImpl(logic);
        createContentEventHandler.add(createContentEventListener);

        String test = "TEST_1";

        try (Socket socket = new Socket("localhost", 9000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){

            controllerCLI.execute();

            out.writeObject(test);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
