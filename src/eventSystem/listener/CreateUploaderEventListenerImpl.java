package eventSystem.listener;

import domainLogic.GLUploaderImpl;
import eventSystem.infrastructure.CreateUploaderEvent;
import eventSystem.infrastructure.CreateUploaderEventListener;

public class CreateUploaderEventListenerImpl implements CreateUploaderEventListener {

    private GLUploaderImpl glUploader;

    public CreateUploaderEventListenerImpl(GLUploaderImpl glUploader) {
        this.glUploader = glUploader;
    }

    @Override
    public void onCreateUploaderEvent(CreateUploaderEvent createUploaderEvent) {
        this.glUploader.createUploader(
                createUploaderEvent.getUploader()
        );
    }
}
