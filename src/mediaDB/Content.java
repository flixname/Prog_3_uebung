package mediaDB;

import observerPattern.observables.ObservableCounter;

import java.util.Collection;

public interface Content {

    String getAddress();
    Collection<Tag> getTags();
    long getAccessCount();
}
