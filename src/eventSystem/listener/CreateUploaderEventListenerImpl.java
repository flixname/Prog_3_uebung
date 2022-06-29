package eventSystem.listener;

import domainLogic.MainLogic;
import eventSystem.infrastructure.CreateUploaderEvent;
import eventSystem.infrastructure.CreateUploaderEventListener;

public class CreateUploaderEventListenerImpl implements CreateUploaderEventListener {

    private MainLogic mainLogic;

    public CreateUploaderEventListenerImpl(MainLogic mainLogic) {
        this.mainLogic = mainLogic;
    }

    @Override
    public void onCreateUploaderEvent(CreateUploaderEvent createUploaderEvent) {
        this.mainLogic.createUploader(
                createUploaderEvent.getUploader());
    }
}
