package domainLogic;

import java.time.Duration;

public class Laenge {

    Duration laenge;

    public Laenge(Duration laenge) {
        this.laenge = laenge;
    }
    public Laenge() { this.laenge = Duration.ZERO; }

    public Duration getLaenge() {
        return laenge;
    }

    public void setLaenge(Duration laenge) {
        this.laenge = laenge;
    }


}
