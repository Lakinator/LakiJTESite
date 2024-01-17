package de.lakinator.lakijtesite.security;

import de.lakinator.lakijtesite.persistence.model.DataRoot;
import de.lakinator.lakijtesite.persistence.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JteUserDetailsService implements UserDetailsService {

    private final DataRoot dataRoot;

    public JteUserDetailsService( DataRoot dataRoot ) {
        this.dataRoot = dataRoot;
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        Optional<User> optionalUser = dataRoot.getUserByName( username );

        if ( optionalUser.isPresent() ) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException( username );
        }

    }
}
