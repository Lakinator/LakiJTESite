package de.lakinator.lakijtesite.persistence;

public class DataRoot {

    private long visitorCount;

    public DataRoot() {
        visitorCount = 0;
    }

    public long getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount( long visitorCount ) {
        this.visitorCount = visitorCount;
    }
}
