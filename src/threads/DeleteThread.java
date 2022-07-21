package threads;

import domainLogic.Logic;

public class DeleteThread extends Thread{
    Logic glContent;
    int randomNumber;

    public DeleteThread(Logic glContent) {
        this.glContent = glContent;
    }
/*
    public void run() {

        do {
            try {
                this.randomNumber = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
                glContent.deleteOne(address);//TODO fehler weg int String
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

 */
}
