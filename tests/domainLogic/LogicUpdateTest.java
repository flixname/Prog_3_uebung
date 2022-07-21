package domainLogic;

import mediaDB.DataImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LogicUpdateTest {

    @Test //Counter noch bei 0
    void counterAtCreate1(){
        Logic logic = new Logic(1000);
        DataImpl data = new DataImpl("Audio", "Bad Religion", "News, Animal", 22, 222);

        Assertions.assertEquals(true, logic.createContent(data));
    }

    @Test //Counter an einer Datei hochzählen
    void goodUpdate1() {
        Logic logic = new Logic(10000);
        logic.update("0");
        Assertions.assertEquals(1, logic.getMediaContentMap().get("0").getAccessCount());
    }

    @Test //Counter an vorhandener Datei hochzählen vorher 0 jetzt 3
    void goodUpdate2() {
        Logic logic = new Logic(10000);
        logic.update("0");
        Assertions.assertEquals(2, logic.getMediaContentMap().get("0").getAccessCount());
    }

    @Test //Counter an anderer Datei an anderer Adresse hochzählen
    void goodUpdate3() {
        Logic logic = new Logic(10000L);
        DataImpl data = new DataImpl("Audio", "Jasmin", "News", 22, 222);
        logic.createContent(data);
        logic.update("1");
        logic.update("1");
        logic.update("1");
        logic.update("1");
        Assertions.assertEquals(4, logic.getMediaContentMap().get("1").getAccessCount());
    }

    @Test //Counter an nicht vorhandener MediaContent
    void goodUpdate4() {
        Logic logic = new Logic(10000);
        Assertions.assertEquals(false, logic.update("2"));
    }
}