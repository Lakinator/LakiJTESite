package de.lakinator.lakijtesite.persistence.config;

import de.lakinator.lakijtesite.persistence.model.DataRoot;
import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfigurationBuilder;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    public EmbeddedStorageManager eclipseStorageManager() {
        EmbeddedStorageConfigurationBuilder configurationBuilder = EmbeddedStorageConfiguration.load( "store-configuration.xml" );
        return configurationBuilder.createEmbeddedStorageFoundation()
                .createEmbeddedStorageManager()
                .start();
    }

    @Bean
    public DataRoot storageRoot( EmbeddedStorageManager storageManager ) {
        if ( storageManager.root() == null ) {
            DataRoot dataRoot = new DataRoot();
            storageManager.setRoot( dataRoot );
            storageManager.storeRoot();
        }

        return ( DataRoot ) storageManager.root();
    }

}
