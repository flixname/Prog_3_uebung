package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class CreateContentEventHandler {
    private List<CreateContentEventListener> createContentEventListenerLinkedList = new LinkedList<>();

    public void add(CreateContentEventListener createContentEventListener) {
        this.createContentEventListenerLinkedList.add(createContentEventListener);
    }

    public void remove(CreateContentEventListener createContentEventListener) {
        this.createContentEventListenerLinkedList.remove(createContentEventListener);
    }

    public void handle(CreateContentEvent createContentEvent){
        for (CreateContentEventListener createUploaderEventListener : createContentEventListenerLinkedList)
        createUploaderEventListener.onCreateContentEvent(createContentEvent); }

}
