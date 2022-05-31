package eventSystem.infrastructure;

import java.util.LinkedList;
import java.util.List;

public class CreateUploaderEventHandler {
    private List<CreateUploaderEventListener> createUploaderEventListenerLinkedList = new LinkedList<>();

    public void add(CreateUploaderEventListener createUploaderEventListener) {
        this.createUploaderEventListenerLinkedList.add(createUploaderEventListener);
    }

    public void remove(CreateUploaderEventListener createUploaderEventListener) {
        this.createUploaderEventListenerLinkedList.remove(createUploaderEventListener);
    }

    public void handle(CreateUploaderEvent createUploaderEvent){
        for (CreateUploaderEventListener createUploaderEventListener : createUploaderEventListenerLinkedList)
            createUploaderEventListener.onCreateUploaderEvent(createUploaderEvent);
    }
}
