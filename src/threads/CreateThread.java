package threads;

import eventSystem.infrastructure.ThreadHandler;

public class CreateThread extends Thread{

    private ThreadHandler threadHandler;

    public CreateThread(ThreadHandler threadHandler) {
        this.threadHandler = threadHandler;
    }

    public void run(){
        do {
           try {
               sleep(100);
           } catch (InterruptedException e){
               throw new RuntimeException("Something went wrong");
           }
           System.out.println("Thread" + this.getName() + "running.");
           threadHandler.handle();
        } while (true);
    }
}
