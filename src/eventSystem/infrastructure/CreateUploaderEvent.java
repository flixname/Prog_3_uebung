package eventSystem.infrastructure;

import java.util.EventObject;

public class CreateUploaderEvent extends EventObject {

    private String name;

    public CreateUploaderEvent(Object source, String name) {
        super(source);
    }

    public String getUploader() {
        return name;
    }
}
