import domainLogic.MainLogic;

import java.util.concurrent.TimeUnit;

public class JOS {
    public static void main(String[] args) {
        MainLogic mainLogic = new MainLogic();

        System.out.println("Now saving to File.txt...");
        //loading();
        mainLogic.saveToFile();

        System.out.println("Now trying to load data from File.txt...");
        //loading();

        mainLogic.loadFromFile("File.txt");
    }
/* For the lulz!
    public static void loading(){
        for (int i = 0; i < 40; i++) {
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
