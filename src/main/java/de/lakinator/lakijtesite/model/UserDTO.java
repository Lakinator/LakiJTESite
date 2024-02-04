package de.lakinator.lakijtesite.model;

import de.lakinator.lakijtesite.persistence.model.User;

public record UserDTO( String username, String email ) {
    public UserDTO( User user ) {
        this( user.getUsername(), user.getEmail() );
    }
}
