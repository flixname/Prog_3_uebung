import domainLogic.Logic;
import mediaDB.DataImpl;
import mediaDB.UploaderStandardBase;
import mediaDB.Uploader;
import mediaDB.UploaderImpl;

import java.util.concurrent.ThreadLocalRandom;

//TODO: aus File die Befüllung für DB probieren

public class JBP {
    public static void main(String[] args) {
        Logic logic_1 = new Logic(Long.MAX_VALUE);

        for (int i = 0; i < 30; i++) {
            try {
                int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 400);
                int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 200);
                DataImpl data = new DataImpl("Audio", "Basic_Channel", "News", randomNumber1, randomNumber2);
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
                Uploader uploader = new UploaderStandardBase(new UploaderImpl(name));
                logic_1.createUploader(uploader);
                System.out.println("created Uploader NR.: " + i);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException();
            }
        }

        System.out.println("actual MAX size of logic: " + logic_1.getLogicSize().getMaxCapacity());
        System.out.println("actual size of logic: " + logic_1.getLogicSize().getActualSize().getSize());
        System.out.println("uploaders in list: " + logic_1.getUploaderLinkedList().size());
        System.out.println("media in map: " + logic_1.getMediaContentMap().size());

        System.out.println("Now saving from logic_1 to JavaBeans.xml..");

        logic_1.saveToXML();

        System.out.println("Now loading from XML to logic_2");
        Logic logic_2 = new Logic();
        logic_2.loadFromXML();

        System.out.println("actual MAX size of logic: " + logic_2.getLogicSize().getMaxCapacity());
        System.out.println("actual size of logic: " + logic_2.getLogicSize().getActualSize().getSize());
        System.out.println("uploaders in list: " + logic_2.getUploaderLinkedList().size());
        System.out.println("media in map: " + logic_2.getMediaContentMap().size());
        System.out.println("media ...: " + logic_2.getMediaContentMap().get(0).getMediaType().getMediaType());
    }
}
