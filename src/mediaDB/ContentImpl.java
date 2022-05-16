package mediaDB;

import eventSystem.util.Address;
import eventSystem.util.ObservableCounter;
import eventSystem.util.ObservableTag;

import java.util.Collection;
import java.util.LinkedList;

public class ContentImpl implements Content {

    private ObservableCounter observableCounter;
    private ObservableTag observableTag;
    private Address address;

    public void setObservableTag(LinkedList<Tag> tagLinkedList){
        this.observableTag.setTagCollection(tagLinkedList);
    }

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
        return this.observableCounter.getValue();
    }
}
