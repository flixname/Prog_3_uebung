package eventSystem.infrastructure;

import java.util.EventListener;

public interface ReadEventListener extends EventListener {
    void onReadEvent(ReadEvent readEvent);
}
