package net.util;

import java.io.DataOutputStream;

public class OutputClientListener implements //Alle listernnr {
//an rückweg denken
    DataOutputStream dataOutputStream;

    public OutputClientListener(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    onCreateEvent(Create Event){
        try{

            dataOutputStream.write("C");
            dataOutputStream.writeUTF(event.cget.....);
        }
    }
}
