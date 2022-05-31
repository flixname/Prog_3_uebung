package eventSystem.listener;

import domainLogic.GLContentImpl;
import eventSystem.infrastructure.DeleteSingleContentEvent;
import eventSystem.infrastructure.DeleteSingleEventListener;

public class DeleteSingleEventListenerImpl implements DeleteSingleEventListener {

    private GLContentImpl glContentImpl;

    public DeleteSingleEventListenerImpl(GLContentImpl glContentImpl) {
        this.glContentImpl = glContentImpl;
    }

    @Override
    public void onDeleteEvent(DeleteSingleContentEvent deleteSingleContentEvent) {
        try {
            this.glContentImpl.deleteOne(deleteSingleContentEvent.getAddress());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
