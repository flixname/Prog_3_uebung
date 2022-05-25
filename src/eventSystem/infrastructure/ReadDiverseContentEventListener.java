package eventSystem.infrastructure;

import java.util.EventListener;

public interface ReadDiverseContentEventListener extends EventListener {
    void onReadEvent(ReadDiverseContentEvent readDiverseContentEvent);
}
