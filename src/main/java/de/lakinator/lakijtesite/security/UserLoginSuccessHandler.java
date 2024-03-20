package de.lakinator.lakijtesite.security;

import de.lakinator.lakijtesite.persistence.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@Configuration
public class UserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final EmbeddedStorageManager storageManager;

    public UserLoginSuccessHandler( EmbeddedStorageManager storageManager ) {
        this.storageManager = storageManager;
    }

    @Override
    public void onAuthenticationSuccess( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {

        if ( authentication.getPrincipal() instanceof User user ) {

            user.setLastLogin( LocalDateTime.now() );

            storageManager.store( user );

            System.out.println( "Updated last login on " + user );
        }

        super.onAuthenticationSuccess( request, response, authentication );
    }
}
