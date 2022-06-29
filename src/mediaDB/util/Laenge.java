package mediaDB.util;

import java.io.Serializable;
import java.time.Duration;

public class Laenge implements Serializable {

    Duration laenge;

    public Laenge(long laenge) {
        this.laenge = Duration.ofSeconds(laenge);
    }

    public Laenge() {
        this.laenge = Duration.ZERO;
    }

    public Duration getLaenge() {
        return laenge;
    }

    public void setLaenge(Duration laenge) {
        this.laenge = laenge;
    }


}
