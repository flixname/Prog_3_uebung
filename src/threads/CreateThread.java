package threads;

import domainLogic.GLContentImpl;
import mediaDB.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class CreateThread extends Thread {

    GLContentImpl glContent;
    int randomNumber1;
    int randomNumber2;

    public CreateThread(GLContentImpl glContent) {
        this.glContent = glContent;
    }


    public void run() {

        do {
            try {
            this.randomNumber1 = ThreadLocalRandom.current().nextInt(1, 4);
            this.randomNumber2 = ThreadLocalRandom.current().nextInt(4, 8);
            glContent.createContent("Audio", "Felix", "Animal,Tutorial", randomNumber1, randomNumber2);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("LinkedList voll");
            }
            System.out.println("Thread" + this.getName() + "created Media");
        } while (true);
    }

    @Override
    public String toString() {
        return "CreateThread";
    }

}
