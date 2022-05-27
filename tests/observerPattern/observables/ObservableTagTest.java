package observerPattern.observables;

import mediaDB.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        List<String> testTagCollection = new LinkedList<>();
        testTagCollection.add("Animal");

        ObservableTag testTag = new ObservableTag(testTagCollection);

        Assertions.assertEquals(true, testTag.getTagCollection().contains(Tag.Animal));
    }
}