package observerPattern.observables;

import mediaDB.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class ObservableTagTest {

    @Test //kommt mit no tags given weil quasi ohne richtigen parameter
    void goodStringToTagConverter() {
        String test = "News";
        ObservableTag testTag = new ObservableTag();

        Tag temp = testTag.stringToTagConverter(test);

        Assertions.assertEquals(Tag.News, temp);
    }

    @Test
    void goodStringToTagConverter2() {

        ObservableTag testTag = new ObservableTag("Animal, News, Lifestyle, Tutorial");

        Assertions.assertEquals(true, testTag.getTagList().contains(Tag.Animal));
    }
}