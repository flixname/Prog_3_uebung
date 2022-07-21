import domainLogic.Logic;
import mediaDB.DataImpl;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.concurrent.ThreadLocalRandom;

public class JOS {
    public static void main(String[] args) {
        Logic logic_1 = new Logic(Integer.MAX_VALUE);

        for (int i = 0; i < 30; i++) {
            try {
                int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 400);
                int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 200);
                DataImpl data = new DataImpl("Audio", "Basic Channel", "News", randomNumber1, randomNumber2);
                logic_1.createContent(data);
                System.out.println("created Media NR.: " + i);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            }
        }

        for (int i = 0; i < 30; i++) {
            try {
                char[] charArray = new char[6];
                for (int j = 0; j < charArray.length; j++) {
                    int randomNumber1 = ThreadLocalRandom.current().nextInt(65, 90);
                    char randomChar = (char) randomNumber1;
                    charArray[j] = randomChar;
                }
                String name = new String(charArray);
                Uploader uploader = new UploaderImpl(name);
                logic_1.createUploader(uploader);
                System.out.println("created Uploader NR.: " + i);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            }
        }

        System.out.println("Now saving from MainLogic1 to File.txt...");
        //loading();
        logic_1.saveJOS();

        Logic logic_2 = new Logic(Integer.MAX_VALUE);
        System.out.println("Now trying to load data from File.txt into mainLogic2...");
        //loading();

        logic_2.loadJOS();

        System.out.println("Check if Content from before is there for Uploaderlist.size, should be some crazy value and is: " + logic_2.getLogicSize().getActualSize().getSize());
    }
/*
// For the lulz! :)
    public static void loading(){
        for (int i = 0; i < 30; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("|");
        }
        System.out.println("");
    }

 */
}

