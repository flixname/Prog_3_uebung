package threads;

import domainLogic.GLContentImpl;
import mediaDB.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreateThread extends Thread {

    GLContentImpl glContent;
    int randomNumber1;
    int randomNumber2;

    List<String> testTagCollection = new LinkedList<>();


    public CreateThread(GLContentImpl glContent) {
        this.glContent = glContent;
    }


    public void run() {

        do {
            try {
            this.randomNumber1 = ThreadLocalRandom.current().nextInt(1, 4);
            this.randomNumber2 = ThreadLocalRandom.current().nextInt(4, 8);
            testTagCollection.add("News");
            testTagCollection.add("Lifestyle");
            glContent.createContent("Audio", "Felix", randomNumber2, randomNumber1, testTagCollection);
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
