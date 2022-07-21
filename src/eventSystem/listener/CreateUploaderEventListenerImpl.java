package eventSystem.listener;

import domainLogic.Logic;

import eventSystem.infrastructure.CreateUploaderEvent;
import eventSystem.infrastructure.CreateUploaderEventListener;
import mediaDB.UploaderImpl;

public class CreateUploaderEventListenerImpl implements CreateUploaderEventListener {

    private Logic logic;

    public CreateUploaderEventListenerImpl(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void onCreateUploaderEvent(CreateUploaderEvent createUploaderEvent) {
        this.logic.createUploader(new UploaderImpl(createUploaderEvent.getUploader()));
    }
}
