package de.lakinator.lakijtesite.model;

import de.lakinator.lakijtesite.persistence.model.User;
import de.lakinator.lakijtesite.security.UserRole;

public record UserDTO( String username, String email, boolean admin ) {
    public UserDTO( User user ) {
        this( user.getUsername(), user.getEmail(), user.getRoles().contains( UserRole.ADMIN ) );
    }
}
