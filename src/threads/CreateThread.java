package threads;

import domainLogic.ContentLogic;

public class CreateThread extends Thread {

    ContentLogic glContent;
    int randomNumber1;
    int randomNumber2;

    public CreateThread(ContentLogic glContent) {
        this.glContent = glContent;
    }


    public void run() {
/*
        do {
            try {
            this.randomNumber1 = ThreadLocalRandom.current().nextInt(1, 4);
            this.randomNumber2 = ThreadLocalRandom.current().nextInt(4, 8);

            glContent.createContent("Audio", "Felix", randomNumber2, randomNumber1, "News, Lifestyle");
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("LinkedList voll");
            }
            System.out.println("Thread" + this.getName() + "created Media");
        } while (true);
    }

    @Override
    public String toString() {
        return "CreateThread";

 */
    }
}
