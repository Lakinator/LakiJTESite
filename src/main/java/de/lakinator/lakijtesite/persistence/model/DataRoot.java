package de.lakinator.lakijtesite.persistence.model;

import java.util.HashMap;
import java.util.Map;

public class DataRoot {

    private long visitorCount;

    private final Map<String, User> userMap;

    public DataRoot() {
        visitorCount = 0;
        userMap = new HashMap<>();
    }

    public long getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount( long visitorCount ) {
        this.visitorCount = visitorCount;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
