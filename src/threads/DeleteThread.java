package threads;

import domainLogic.GLContentImpl;

import java.util.concurrent.ThreadLocalRandom;

public class DeleteThread extends Thread{
    GLContentImpl glContent;
    int randomNumber;

    public DeleteThread(GLContentImpl glContent) {
        this.glContent = glContent;
    }

    public void run() {

        do {
            try {
                this.randomNumber = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
                glContent.deleteOne(randomNumber);
                System.out.println("Thread" + this.getName() + "deleted Media");
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Out of Bounds");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "CreateThread";
    }
}
