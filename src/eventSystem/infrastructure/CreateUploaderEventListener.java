package eventSystem.infrastructure;

import java.util.EventListener;

public interface CreateUploaderEventListener extends EventListener {
    void onCreateUploaderEvent(CreateUploaderEvent createUploaderEvent);
}
