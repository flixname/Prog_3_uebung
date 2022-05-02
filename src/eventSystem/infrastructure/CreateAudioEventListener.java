package eventSystem.infrastructure;

import java.util.EventListener;

public interface CreateAudioEventListener extends EventListener {
    void onCreateEvent(CreateAudioEvent createAudioEvent);
}
