package mediaDB;

import java.util.Collection;

public class ContentImpl implements Content{

    String address;

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public Collection<Tag> getTags() {
        return null;
    }

    @Override
    public long getAccessCount() {
        return 0;
    }
}
