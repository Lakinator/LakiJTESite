package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.model.UserDTO;
import de.lakinator.lakijtesite.model.VisitorInfoDTO;
import de.lakinator.lakijtesite.persistence.DataRoot;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final EmbeddedStorageManager storageManager;

    private final DataRoot dataRoot;

    public MainController( EmbeddedStorageManager storageManager, DataRoot dataRoot ) {
        this.storageManager = storageManager;
        this.dataRoot = dataRoot;
    }

    @GetMapping( "/" )
    public String rootView( Model model, HttpServletResponse response ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description" ) );
        return "layout";
    }

    @GetMapping( "/visitors" )
    public String visitorView( Model model, HttpServletResponse response ) {
        dataRoot.setVisitorCount( dataRoot.getVisitorCount() + 1 );
        storageManager.store( dataRoot );

        model.addAttribute( "pageContext", new PageContext( "Visitor page", "Here is the count of all page visitors" ) );
        model.addAttribute( "visitorInfo", new VisitorInfoDTO( dataRoot.getVisitorCount() ) );
        return "visitors";
    }

    @GetMapping( "/registration" )
    public String registrationView( Model model, HttpServletResponse response ) {
        model.addAttribute( "pageContext", new PageContext( "Registration page", "Nice description" ) );
        return "registration";
    }

    @PostMapping( "/registration" )
    public String register( Model model, HttpServletRequest request,
                            @RequestParam( "username" ) String username,
                            @RequestParam( "email" ) String email,
                            @RequestParam( "password" ) String password,
                            @RequestParam( "passwordConfirm" ) String passwordConfirm ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description" ) );

        UserDTO userDTO = new UserDTO( username, email, password );

        if ( !userDTO.getPassword().equals( passwordConfirm ) ) {
            model.addAttribute( "passwordErrors", new String[]{ "Passwords don't match!" } );
            model.addAttribute( "user", userDTO );

            return "registration";
        }

        // TODO: check if username exists

        return "redirect:/visitors";
    }

}
