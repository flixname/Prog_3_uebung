package verwaltung;


import mediaDB.AudioVideo;

public interface AudioVideoController extends AudioVideo {

    /**
     * Ein Zähler für die Zugriffe auf die jeweiligen Daten
     * @return neuer Stand des Counters
     */
    long incrementAccessCounter();

}
