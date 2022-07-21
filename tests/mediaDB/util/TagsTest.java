package mediaDB.util;

import mediaDB.Tag;
import mediaDB.util.Tags;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TagsTest {
    Tags tags = new Tags();

    @Test //Bekommt einen String und gibt dann Tag Collection zuerueck
    void add_Tag1() {

        this.tags.addTag("News");

        Assertions.assertEquals(Tag.News, this.tags.getTagHashMap().get(3));
    }

    @Test //bekommt einen String, teilt diesen auf und gibt dann Tag Collection mit 4 Tags zuerueck (Animal immer 0, Tutorial 1, Lifestyle 2, News 3)
    void add_Tag2() {

        Tags tags2 = new Tags("Animal, News, Lifestyle, Tutorial"); //in richtiger Reihenfolge eingegeben

        Assertions.assertEquals(Tag.Animal, tags2.getTagHashMap().get(0));
        Assertions.assertEquals(Tag.Tutorial, tags2.getTagHashMap().get(1));
        Assertions.assertEquals(Tag.Lifestyle, tags2.getTagHashMap().get(2));
        Assertions.assertEquals(Tag.News, tags2.getTagHashMap().get(3));
    }

    @Test //bekommt einen String, teilt diesen auf und gibt dann Tag Collection mit 4 Tags zuerueck (Animal immer 0, Tutorial 1, Lifestyle 2, News 3)
    void add_Tag3() {

        Tags tags2 = new Tags("Tutorial, Animal, News, Lifestyle"); //in falscher Reihenfolge eingegeben

        Assertions.assertEquals(Tag.Animal, tags2.getTagHashMap().get(0));
        Assertions.assertEquals(Tag.Tutorial, tags2.getTagHashMap().get(1));
        Assertions.assertEquals(Tag.Lifestyle, tags2.getTagHashMap().get(2));
        Assertions.assertEquals(Tag.News, tags2.getTagHashMap().get(3));
    }

    @Test //bekommt nur zwei
    void add_Tag4() {

        Tags tags2 = new Tags("Animal, Tutorial");

        Assertions.assertEquals(Tag.Animal, tags2.getTagHashMap().get(0));
        Assertions.assertEquals(Tag.Tutorial, tags2.getTagHashMap().get(1));
    }

    @Test //kein tag in Collection weil nur Komma (",")
    void add_KommaForNoTag() {

        this.tags = new Tags(",");

        Assertions.assertEquals(0, this.tags.getTagHashMap().size());
    }

    @Test //garnichts in den Konstruktor
    void add_NothingForNothing() {

        this.tags = new Tags();

        Assertions.assertEquals(0, this.tags.getTagHashMap().size());
    }



}