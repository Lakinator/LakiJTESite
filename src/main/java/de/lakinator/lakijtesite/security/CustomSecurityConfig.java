package de.lakinator.lakijtesite.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity( securedEnabled = true, jsr250Enabled = true )
public class CustomSecurityConfig {

    private final UserLoginSuccessHandler authenticationSuccessHandler;

    public CustomSecurityConfig( UserLoginSuccessHandler authenticationSuccessHandler ) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http
                .csrf( AbstractHttpConfigurer::disable )
                .authorizeHttpRequests( ( requests ) -> requests
                        .requestMatchers( "/", "/login", "/registration", "/error", "/css/**", "/js/**", "img/**" ).permitAll()
                        .requestMatchers( "/admin" ).hasAuthority( UserRole.ADMIN.name() )
                        .anyRequest().authenticated()
                )
                .formLogin( ( form ) -> form
                        .loginPage( "/login" )
                        .successHandler( authenticationSuccessHandler )
                        .permitAll()
                )
                .logout( logout -> logout
                        .logoutSuccessUrl( "/" )
                        .permitAll()
                );

        return http.build();
    }

    /**
     * For testing purposes, don't encode the password, just keep it plain text
     * For production later on, replace it with {@code PasswordEncoderFactories.createDelegatingPasswordEncoder()}
     *
     * @return -
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode( CharSequence rawPassword ) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches( CharSequence rawPassword, String encodedPassword ) {
                return rawPassword.toString().equals( encodedPassword );
            }
        };
    }

}
