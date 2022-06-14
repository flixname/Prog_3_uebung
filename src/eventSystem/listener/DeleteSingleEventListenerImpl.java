package eventSystem.listener;

import domainLogic.ContentLogic;
import eventSystem.infrastructure.DeleteSingleContentEvent;
import eventSystem.infrastructure.DeleteSingleEventListener;

public class DeleteSingleEventListenerImpl implements DeleteSingleEventListener {

    private ContentLogic contentLogic;

    public DeleteSingleEventListenerImpl(ContentLogic contentLogic) {
        this.contentLogic = contentLogic;
    }

    @Override
    public void onDeleteEvent(DeleteSingleContentEvent deleteSingleContentEvent) {
        try {
            //this.glContentImpl.deleteSingleContent(deleteSingleContentEvent.getAddress());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
