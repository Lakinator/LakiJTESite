package de.lakinator.lakijtesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication( exclude = { SecurityAutoConfiguration.class } )
public class LakiJteSiteApplication {

    public static void main( String[] args ) {
        SpringApplication.run( LakiJteSiteApplication.class, args );
    }

}
