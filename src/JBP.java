import domainLogic.ContentLogic;
import domainLogic.MainLogic;
import domainLogic.UploaderLogic;

import java.util.concurrent.ThreadLocalRandom;

//TODO: aus File die Befüllung für DB probieren

public class JBP {
    public static void main(String[] args) {
        MainLogic mainLogic1 = new MainLogic(1000000000);
        MainLogic mainLogic2 = new MainLogic(1000000000);




        mainLogic1.saveToXML();

        mainLogic2.loadFromXML();

    }

    public static ContentLogic createSomeFiles() {

        ContentLogic contentLogic = new ContentLogic(1000000000);
        for (int i = 0; i < 30; i++) {
            try {
                int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 400);
                int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 200);

                //contentLogic.createContent("Audio", "defaultname", "News, Lifestyle", randomNumber1, randomNumber2);
                System.out.println("created Media NR.: " + i);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            }
        }
        return contentLogic;
    }

}
