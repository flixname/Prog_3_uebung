package net;

import domainLogic.ContentLogic;
import eventSystem.infrastructure.CreateContentEventListener;
import eventSystem.listener.CreateContentEventListenerImpl;


import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        if(args.length >0){
            if(args[0].equals("TCP")){ //usereingabe TCP

                try(ServerSocket serverSocket=new ServerSocket(7000);) {
                    try (Socket socket=serverSocket.accept(); //Socket hier Port IP+PORT
                         DataInputStream in=new DataInputStream(socket.getInputStream());
                         DataOutputStream out=new DataOutputStream(socket.getOutputStream());){
                        //System.out.println("client: "+socket.getInetAddress()+":"+socket.getPort());


                        ContentLogic contentLogic = new ContentLogic();
                        ServerInputHandler serverInputHandler = new ServerInputHandler(in);
                        CreateContentEventListener createContentEventListener = new CreateContentEventListenerImpl(contentLogic);
                        createContentEventHandler.add(createContentEventListener);
                        //alle listener hier rein
                        /*
                        while (true){
                            out.writeInt(-in.readInt());
                        }
                        */
                    } catch (EOFException e) {
                        System.out.println("client disconnect");
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
