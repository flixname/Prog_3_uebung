package eventSystem.listener;

import domainLogic.Logic;
import eventSystem.infrastructure.DeleteSingleContentEvent;
import eventSystem.infrastructure.DeleteSingleEventListener;

public class DeleteSingleEventListenerImpl implements DeleteSingleEventListener {

    private Logic logic;

    public DeleteSingleEventListenerImpl(Logic logic) {
        this.logic = logic;
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
