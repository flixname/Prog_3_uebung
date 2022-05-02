package eventSystem.listener;

import domainLogic.Verwaltung;
import eventSystem.infrastructure.CreateAudioEvent;
import eventSystem.infrastructure.CreateAudioEventListener;
import mediaDB.Audio;

public class CreateAudioListenerImpl implements CreateAudioEventListener {


    private Verwaltung model;
    private int dataNr;
    private Audio audio;

    public CreateAudioListenerImpl(Verwaltung model, int dataNr, Audio audio) {
        this.model = model;
        this.dataNr = dataNr;
        this.audio = audio;
    }

    @Override
    public void onCreateEvent(CreateAudioEvent createAudioEvent) {
        this.model.create(this.dataNr, this.audio);
    }
}
