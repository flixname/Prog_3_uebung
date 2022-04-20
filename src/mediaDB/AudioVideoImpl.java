package mediaDB;

import verwaltung.AudioVideoController;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;

public class AudioVideoImpl implements AudioVideoController {

    long AccessCount;

    @Override
    public int getSamplingRate() {
        return 0;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public Collection<Tag> getTags() {
        return null;
    }

    @Override
    public long getAccessCount() {
        return this.AccessCount;
    }

    @Override
    public BigDecimal getBitrate() {
        return null;
    }

    @Override
    public Duration getLength() {
        return null;
    }

    @Override
    public BigDecimal getSize() {
        return null;
    }

    @Override
    public Uploader getUploader() {
        return null;
    }

    @Override
    public Date getUploadDate() {
        return null;
    }

    @Override
    public int getResolution() {
        return 0;
    }

    @Override
    public long incrementAccessCounter() {
        final long increase = 1;  //increase by 1
        return this.AccessCount = this.AccessCount + increase;
    }
}
