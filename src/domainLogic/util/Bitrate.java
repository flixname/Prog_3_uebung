package domainLogic.util;

import java.math.BigDecimal;

public class Bitrate {

    private BigDecimal bitrate;

    public Bitrate(BigDecimal bitrate) { this.bitrate = bitrate; }
    public Bitrate(){ this.bitrate = BigDecimal.valueOf(0.0); }

    public BigDecimal getBitrate() {
        return bitrate;
    }

    public void setBitrate(BigDecimal bitrate) {
        this.bitrate = bitrate;
    }
}
