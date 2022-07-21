package eventSystem.listener;

import eventSystem.infrastructure.CreateContentEvent;
import eventSystem.infrastructure.CreateContentEventListener;
import mediaDB.DataImpl;

import java.io.DataOutputStream;
import java.io.IOException;

public class OutputClientListenerImpl implements CreateContentEventListener {
//an rückweg denken
    DataOutputStream dataOutputStream;

    public OutputClientListenerImpl(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void onCreateContentEvent(CreateContentEvent createContentEvent) {
        try {
            dataOutputStream.writeUTF(createContentEvent.getDataType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
