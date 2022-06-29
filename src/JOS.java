import domainLogic.ContentLogic;
import domainLogic.MainLogic;
import domainLogic.UploaderLogic;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.concurrent.ThreadLocalRandom;

public class JOS {
    public static void main(String[] args) {
        MainLogic mainLogic1 = new MainLogic(1000000000);

        for (int i = 0; i < 30; i++) {
            try {
                int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 400);
                int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 200);
                mainLogic1.createContent("Audio", "Basic Channel", "News", randomNumber1, randomNumber2);
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
                mainLogic1.createUploader(uploader.getName());
                System.out.println("created Uploader NR.: " + i);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            }
        }

        System.out.println("Now saving from MainLogic1 to File.txt...");
        //loading();
        mainLogic1.saveJOS();

        MainLogic mainLogic2 = new MainLogic(1000000000);
        System.out.println("Now trying to load data from File.txt into mainLogic2...");
        //loading();

        mainLogic2.loadJOS("File.txt");

        System.out.println("Check if Content from before is there for Uploaderlist.size, should be 30 and is: " + mainLogic2.readUploader().size());
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

