package de.lakinator.lakijtesite.persistence;

import de.lakinator.lakijtesite.persistence.model.DataRoot;
import de.lakinator.lakijtesite.persistence.model.User;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageService {

    private final PasswordEncoder passwordEncoder;

    private final EmbeddedStorageManager storageManager;

    private final DataRoot dataRoot;

    public StorageService( PasswordEncoder passwordEncoder, EmbeddedStorageManager storageManager, DataRoot dataRoot ) {
        this.passwordEncoder = passwordEncoder;
        this.storageManager = storageManager;
        this.dataRoot = dataRoot;
    }

    public void incrementVisitorCount() {
        dataRoot.setVisitorCount( dataRoot.getVisitorCount() + 1 );
        storageManager.store( dataRoot );
    }

    public long getVisitorCount() {
        return dataRoot.getVisitorCount();
    }

    public boolean addStandardUser( User user ) {
        if ( !user.getRoles().contains( "STANDARD" ) ) {
            user.getRoles().add( "STANDARD" );
        }

        return addUser( user );
    }

    private boolean addUser( User user ) {
        if ( !existsUser( user.getUsername() ) ) {
            user.setPassword( passwordEncoder.encode( user.getPassword() ) );

            dataRoot.getUserMap().put( user.getUsername(), user );
            storageManager.store( dataRoot.getUserMap() );
            return true;
        } else {
            return false;
        }
    }

    public boolean existsUser( String name ) {
        return dataRoot.getUserMap().containsKey( name );
    }

    public Optional<User> getUserByName( String name ) {
        User user = dataRoot.getUserMap().get( name );
        return user != null ? Optional.of( user ) : Optional.empty();
    }
}
