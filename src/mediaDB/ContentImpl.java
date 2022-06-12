package mediaDB;

import observerPattern.observables.ObservableTag;

import java.util.ArrayList;
import java.util.Collection;

public class ContentImpl implements Content {

    ObservableTag observableTag = new ObservableTag();

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public Collection<Tag> getTags() {
        return null;
    }

    @Override
    public long getAccessCount() {
        return 0;
    }
}
