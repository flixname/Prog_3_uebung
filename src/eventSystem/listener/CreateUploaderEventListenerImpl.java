package eventSystem.listener;

import domainLogic.UploaderLogic;
import eventSystem.infrastructure.CreateUploaderEvent;
import eventSystem.infrastructure.CreateUploaderEventListener;

public class CreateUploaderEventListenerImpl implements CreateUploaderEventListener {

    private UploaderLogic glUploader;

    public CreateUploaderEventListenerImpl(UploaderLogic glUploader) {
        this.glUploader = glUploader;
    }

    @Override
    public void onCreateUploaderEvent(CreateUploaderEvent createUploaderEvent) {
        this.glUploader.createUploader(
                createUploaderEvent.getUploader()
        );
    }
}
