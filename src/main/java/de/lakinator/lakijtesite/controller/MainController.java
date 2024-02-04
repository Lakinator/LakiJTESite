package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.AuthenticationUserDTO;
import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.model.VisitorInfoDTO;
import de.lakinator.lakijtesite.persistence.StorageService;
import de.lakinator.lakijtesite.persistence.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final StorageService storageService;

    public MainController( StorageService storageService ) {
        this.storageService = storageService;
    }

    @GetMapping( "/" )
    public String rootView( Model model, @AuthenticationPrincipal User user ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description", user ) );
        return "layout";
    }

    @GetMapping( "/login" )
    public String loginView( Model model, @AuthenticationPrincipal User user ) {
        if ( user != null ) {
            return "redirect:/error?code=124";
        }

        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description", user ) );
        return "login";
    }

    @GetMapping( "/visitors" )
    public String visitorView( Model model, @AuthenticationPrincipal User user ) {
        storageService.incrementVisitorCount();

        model.addAttribute( "pageContext", new PageContext( "Visitor page", "Here is the count of all page visitors", user ) );
        model.addAttribute( "visitorInfo", new VisitorInfoDTO( storageService.getVisitorCount() ) );
        return "visitors";
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
    public String register( Model model, @AuthenticationPrincipal User user, AuthenticationUserDTO authenticationUserDTO ) {
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

        if ( !storageService.addStandardUser( new User( authenticationUserDTO.username(), authenticationUserDTO.email(), authenticationUserDTO.password() ) ) ) {
            return "redirect:/error?code=123";
        }

        return "redirect:/login";
    }

}
