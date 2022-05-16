package eventSystem.listener;

import domainLogic.GLContent;
import domainLogic.GLUploader;
import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;

//TODO: evtl fehler hier
public class CreateContentEventListenerImpl implements CreateContentEventListener {

    private GLContent model;
    private GLUploader uploader;

    public CreateContentEventListenerImpl(GLContent model, GLUploader uploader) {
        this.model = model;
        this.uploader = uploader;
    }

    @Override
    public void onCreateEvent(CreateContentEvent createContentEvent) {
        this.model.createContent(createContentEvent.getContent(), createUploader.getUploader());
    }
}
