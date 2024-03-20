package de.lakinator.lakijtesite.persistence;

import de.lakinator.lakijtesite.persistence.model.DataRoot;
import de.lakinator.lakijtesite.persistence.model.User;
import de.lakinator.lakijtesite.security.UserRole;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if ( !user.getRoles().contains( UserRole.STANDARD ) ) {
            user.getRoles().add( UserRole.STANDARD );
        }

        return addUser( user );
    }

    private boolean addUser( User user ) {
        if ( !existsUser( user.getUsername() ) ) {
            user.setPassword( passwordEncoder.encode( user.getPassword() ) );

            if ( dataRoot.getUserMap().isEmpty() ) {
                // first user will automatically be an admin
                if ( !user.getRoles().contains( UserRole.ADMIN ) ) {
                    user.getRoles().add( UserRole.ADMIN );
                }
            }

            dataRoot.getUserMap().put( user.getUsername(), user );
            storageManager.store( dataRoot.getUserMap() );
            return true;
        } else {
            return false;
        }
    }

    public void updateUser( User user ) {
        storageManager.store( user );
    }

    public boolean existsUser( String name ) {
        return dataRoot.getUserMap().containsKey( name );
    }

    public Optional<User> getUserByName( String name ) {
        User user = dataRoot.getUserMap().get( name );
        return user != null ? Optional.of( user ) : Optional.empty();
    }

    public List<User> getUsers() {
        return dataRoot.getUserMap().values().stream().toList();
    }

}
