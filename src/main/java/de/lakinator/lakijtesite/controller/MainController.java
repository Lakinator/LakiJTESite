package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.model.UserDTO;
import de.lakinator.lakijtesite.model.VisitorInfoDTO;
import de.lakinator.lakijtesite.persistence.StorageService;
import de.lakinator.lakijtesite.persistence.model.User;
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
    public String rootView( Model model ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description" ) );
        return "layout";
    }

    @GetMapping( "/login" )
    public String loginView( Model model ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description" ) );
        return "login";
    }

    @GetMapping( "/visitors" )
    public String visitorView( Model model ) {
        storageService.incrementVisitorCount();

        model.addAttribute( "pageContext", new PageContext( "Visitor page", "Here is the count of all page visitors" ) );
        model.addAttribute( "visitorInfo", new VisitorInfoDTO( storageService.getVisitorCount() ) );
        return "visitors";
    }

    @GetMapping( "/registration" )
    public String registrationView( Model model ) {
        model.addAttribute( "pageContext", new PageContext( "Registration page", "Nice description" ) );
        return "registration";
    }

    @PostMapping( "/registration" )
    public String register( Model model, UserDTO userDTO ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description" ) );

        if ( !userDTO.password().equals( userDTO.passwordConfirm() ) ) {
            model.addAttribute( "passwordErrors", new String[]{ "Passwords don't match!" } );
            model.addAttribute( "user", userDTO );

            return "registration";
        }

        if ( storageService.existsUser( userDTO.username() ) ) {
            model.addAttribute( "usernameErrors", new String[]{ "This user already exists!" } );
            model.addAttribute( "user", userDTO );

            return "registration";
        }

        storageService.addStandardUser( new User( userDTO.username(), userDTO.email(), userDTO.password() ) );

        return "redirect:/login";
    }

}
