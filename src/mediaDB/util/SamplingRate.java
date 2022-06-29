package mediaDB.util;

import java.io.Serializable;

public class SamplingRate implements Serializable {
    int samplingRate;

    public SamplingRate() {
        this.samplingRate = 44;
    }

    public void setSamplingRate(int samplingRate) {
        this.samplingRate = samplingRate;
    }

    public int getSamplingRate() {
        return samplingRate;
    }
}
