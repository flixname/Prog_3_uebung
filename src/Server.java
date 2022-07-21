
import domainLogic.Logic;
import eventSystem.infrastructure.CreateContentEventHandler;
import eventSystem.infrastructure.CreateContentEventListener;
import eventSystem.infrastructure.ReadDiverseContentEventHandler;
import eventSystem.infrastructure.ReadDiverseContentEventListener;
import eventSystem.listener.CreateContentEventListenerImpl;
import eventSystem.listener.ReadDiverseContentEventListenerImpl;
import ui.cli.commands.ControllerCLI;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private Socket socket;
    private Logic logic;
    private ControllerCLI controllerCLI;

    public Server(Socket socket, Logic logic){
        this.socket = socket;
        this.logic = logic;
    }

    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(9000);) {
            while(true){
                Socket socket=serverSocket.accept();
                Server server = new Server(socket, new Logic(Long.MAX_VALUE));
                System.out.println("new client@"+socket.getInetAddress()+":"+socket.getPort());
                new Thread(server).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream())) {
            try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                System.out.println("client@"+socket.getInetAddress()+":"+socket.getPort()+" connected");
                String error = this.executeSession(in, out);
                if(null!=error){
                    out.writeChar('F');
                    out.writeUTF(error);
                    System.out.println("client@"+socket.getInetAddress()+":"+socket.getPort()+" error="+error);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client@"+socket.getInetAddress()+":"+socket.getPort()+" disconnected");
    }

    private String executeSession(ObjectInputStream in, ObjectOutputStream out) throws IOException {

        this.controllerCLI = new ControllerCLI();

        CreateContentEventHandler createContentEventHandler = new CreateContentEventHandler();
        CreateContentEventListener createContentEventListener = new CreateContentEventListenerImpl(logic);
        createContentEventHandler.add(createContentEventListener);

        ReadDiverseContentEventHandler readDiverseContentEventHandler = new ReadDiverseContentEventHandler();
        ReadDiverseContentEventListener readDiverseContentEventListener = new ReadDiverseContentEventListenerImpl(logic);
        readDiverseContentEventHandler.add(readDiverseContentEventListener);

        controllerCLI.setCreateContentEventHandler(createContentEventHandler);
        controllerCLI.setReadDiverseContentEventHandler(readDiverseContentEventHandler);
        controllerCLI.execute();

        System.out.println("cli started");

        while (true){
            try {
                System.err.println((String)in.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

