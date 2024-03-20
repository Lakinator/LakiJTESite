package de.lakinator.lakijtesite.admin;

import de.lakinator.lakijtesite.persistence.model.User;

import java.util.List;

public record AdminDetailDTO( List<User> userList ) {
}
