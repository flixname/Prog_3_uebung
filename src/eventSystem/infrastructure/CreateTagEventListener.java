package eventSystem.infrastructure;

import java.util.EventListener;

public interface CreateTagEventListener extends EventListener{
        void onCreateTagEvent(CreateTagEvent createTagEvent);
}
