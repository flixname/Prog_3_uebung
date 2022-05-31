package eventSystem.infrastructure;

import java.util.EventObject;

public class CreateUploaderEvent extends EventObject {

    private String uploader;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CreateUploaderEvent(Object source, String uploader) {
        super(source);
    }

    public String getUploader() {
        return uploader;
    }
}
