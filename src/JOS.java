import domainLogic.ContentLogic;
import domainLogic.MainLogic;
import domainLogic.UploaderLogic;
import mediaDB.Uploader;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class JOS {
    public static void main(String[] args) {
        MainLogic mainLogic1 = new MainLogic();
        System.out.println("Size of ContentLogic HashMap is now: " + mainLogic1.getUploaderLogic().getContentLogic().getAddressMediaContentHashMap().size());

        ContentLogic contentLogic = new ContentLogic();

        UploaderLogic uploaderLogic = new UploaderLogic();
        uploaderLogic.setContentLogic(createSomeFiles());
        mainLogic1.setUploaderLogic(uploaderLogic);


        System.out.println("Now saving from MainLogic1 to File.txt...");
        //loading();
        mainLogic1.saveToFile();

        MainLogic mainLogic2 = new MainLogic();
        System.out.println("Now trying to load data from File.txt into mainLogic2...");
        //loading();

        mainLogic2.loadFromFile("File.txt");

        System.out.println("Size of ContentLogic HashMap in MainLogic2 should be 30 also, and is: " + mainLogic2.getUploaderLogic().getContentLogic().getAddressMediaContentHashMap().size());
    }

    public static ContentLogic createSomeFiles() {

        ContentLogic contentLogic = new ContentLogic();
        for (int i = 0; i < 30; i++) {
            try {
                int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 400);
                int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 200);

                contentLogic.createContent("Audio", "defaultname", "News, Lifestyle", randomNumber1, randomNumber2);
                System.out.println("created Media NR.: " + i);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            }
        }
        return contentLogic;
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

