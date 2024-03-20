package de.lakinator.lakijtesite.registration;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.persistence.StorageService;
import de.lakinator.lakijtesite.persistence.model.User;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final StorageService storageService;

    public RegistrationController( StorageService storageService ) {
        this.storageService = storageService;
    }

    @GetMapping( "/registration" )
    public String registrationView( Model model, @AuthenticationPrincipal User user ) {
        if ( user != null ) {
            return "redirect:/error?code=124";
        }

        model.addAttribute( "pageContext", new PageContext( "Registration page", "Nice description", user ) );
        return "registration";
    }

    @PostMapping( "/registration" )
    public String register( Model model, @AuthenticationPrincipal User user, @Valid AuthenticationUserDTO authenticationUserDTO ) {
        if ( user != null ) {
            return "redirect:/error?code=124";
        }

        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description", user ) );

        if ( !authenticationUserDTO.password().equals( authenticationUserDTO.passwordConfirm() ) ) {
            model.addAttribute( "passwordErrors", new String[]{ "Passwords don't match!" } );
            model.addAttribute( "user", authenticationUserDTO );

            return "registration";
        }

        if ( storageService.existsUser( authenticationUserDTO.username() ) ) {
            model.addAttribute( "usernameErrors", new String[]{ "This user already exists!" } );
            model.addAttribute( "user", authenticationUserDTO );

            return "registration";
        }

        // TODO: check if email exists

        if ( !storageService.addStandardUser( new User( authenticationUserDTO.username(), authenticationUserDTO.email(), authenticationUserDTO.password() ) ) ) {
            return "redirect:/error?code=123";
        }

        return "redirect:/login";
    }

}
