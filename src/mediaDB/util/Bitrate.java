package mediaDB.util;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bitrate implements Serializable {

    private BigDecimal bitrate;

    public Bitrate(double bitrate) {

        this.bitrate = BigDecimal.valueOf(bitrate);
    }

    public Bitrate(){
        this.bitrate = BigDecimal.valueOf(0);
    }

    public BigDecimal getBitrate() {
        return this.bitrate;
    }
}
