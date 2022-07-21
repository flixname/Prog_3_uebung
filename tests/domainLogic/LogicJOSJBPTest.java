package domainLogic;

import mediaDB.DataImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicJOSJBPTest {

    @Test //erstellt Mediacontent um im naechsten Test zu pruefen ob abrufbar per JOS
    void save_withJOS(){
        Logic logic_1 = new Logic(40000000);
        DataImpl data = new DataImpl("Audio", "Harald", "Animal", 1000, 2000);
        logic_1.createContent(data);

        logic_1.saveJOS();
    }

    @Test
    void loadFromFileWithJOS() {
        Logic logic_2 = new Logic(40000000);
        logic_2.loadJOS();

        assertEquals(3000, logic_2.getLogicSize().getActualSize().getSize());
        //assertEquals("Harald", logic_2.getMediaContentMap().get(0).getUploader().getName());
    }

    @Test
    void save_withJBP(){
        Logic logic_1 = new Logic(4000);
        DataImpl data = new DataImpl("Audio", "Outkast", "Animal", 1000, 2000);
        logic_1.createContent(data);

        logic_1.saveToXML();
        assertEquals(3000, logic_1.getLogicSize().getActualSize().getSize());

        logic_1.loadFromXML();
        assertEquals(3000, logic_1.getLogicSize().getActualSize().getSize());
        assertEquals("Outkast", logic_1.getMediaContentMap().get(0).getUploader().getName());
    }

    @Test
    void loadFromXML() {
        Logic logic_2 = new Logic(1);
        logic_2.loadFromXML();

        assertEquals(3000, logic_2.getLogicSize().getActualSize().getSize());
        assertEquals("Outkast", logic_2.getMediaContentMap().get(0).getUploader().getName());
    }

}