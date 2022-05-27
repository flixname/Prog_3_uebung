package eventSystem.infrastructure;

import java.util.Collection;
import java.util.EventObject;

public class CreateTagEvent extends EventObject {

    private Collection<String> tagCollection;
    private int dataNr;


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CreateTagEvent(Object source, Collection<String> tagCollection, int dataNr) {
        super(source);
        this.tagCollection = tagCollection;
        this.dataNr = dataNr;
    }

    public Collection<String> getTagCollection() {
        return tagCollection;
    }

    public int getDataNr() {
        return dataNr;
    }
}
