package threads;

import domainLogic.GLContentImpl;
import mediaDB.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class CreateThread extends Thread {

    LinkedList<Tag> tagLinkedList = new LinkedList<>();
    GLContentImpl glContent;
    int randomNumber;

    public CreateThread(GLContentImpl glContent) {
        this.glContent = glContent;
    }


    public void run() {

        tagLinkedList.add(Tag.News);

        do {
            try {
            this.randomNumber = ThreadLocalRandom.current().nextInt(1, 4);
            glContent.createContent("Audio", "Felix", tagLinkedList, BigDecimal.valueOf(randomNumber), Duration.of(randomNumber, ChronoUnit.MILLIS));
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
