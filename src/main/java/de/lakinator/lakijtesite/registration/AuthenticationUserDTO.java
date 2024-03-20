package de.lakinator.lakijtesite.registration;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AuthenticationUserDTO(
        @NotNull
        @Size( min = 4, max = 32, message = "Username must be between 4 and 32 characters" )
        String username,
        @NotNull
        String email,
        @NotNull
        @Size( min = 6, max = 32, message = "Password must be between 6 and 32 characters" )
        String password,
        @NotNull
        @Size( min = 6, max = 32, message = "Password must be between 6 and 32 characters" )
        String passwordConfirm ) {
}
