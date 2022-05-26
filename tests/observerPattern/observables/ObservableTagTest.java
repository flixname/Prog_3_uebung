package observerPattern.observables;

import mediaDB.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTagTest {

    @Test
    void stringToTagConverter() {
        String test = "News";
        ObservableTag testTag = new ObservableTag();

        Tag temp = testTag.stringToTagConverter(test);

        Assertions.assertEquals(Tag.News, temp);
    }
}