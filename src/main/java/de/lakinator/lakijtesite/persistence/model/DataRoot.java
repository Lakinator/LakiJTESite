package de.lakinator.lakijtesite.persistence.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataRoot {

    private final Map<String, User> userMap;

    private long visitorCount;

    public DataRoot() {
        visitorCount = 0;
        userMap = new HashMap<>();
    }

    public boolean existsUser( String name ) {
        return userMap.containsKey( name );
    }

    public boolean addUser( User user ) {
        if ( !existsUser( user.getUsername() ) ) {
            userMap.put( user.getUsername(), user );
            return true;
        } else {
            return false;
        }
    }

    public Optional<User> getUserByName( String name ) {
        User user = userMap.get( name );
        return user != null ? Optional.of( user ) : Optional.empty();
    }

    public long getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount( long visitorCount ) {
        this.visitorCount = visitorCount;
    }
}
