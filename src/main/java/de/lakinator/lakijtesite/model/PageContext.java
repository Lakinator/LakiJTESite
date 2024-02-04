package de.lakinator.lakijtesite.model;

import de.lakinator.lakijtesite.persistence.model.User;

public record PageContext( String title, String description, UserDTO user ) {
    public PageContext( String title, String description, User user ) {
        this( title, description, user != null ? new UserDTO( user ) : null );
    }
}
