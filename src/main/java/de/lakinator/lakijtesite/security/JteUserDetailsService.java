package de.lakinator.lakijtesite.security;

import de.lakinator.lakijtesite.persistence.StorageService;
import de.lakinator.lakijtesite.persistence.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JteUserDetailsService implements UserDetailsService {

    private final StorageService storageService;

    public JteUserDetailsService( StorageService storageService ) {
        this.storageService = storageService;
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        Optional<User> optionalUser = storageService.getUserByName( username );

        if ( optionalUser.isPresent() ) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException( username );
        }

    }
}
