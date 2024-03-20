package de.lakinator.lakijtesite.admin;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.persistence.StorageService;
import de.lakinator.lakijtesite.persistence.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AdminController {

    private final StorageService storageService;

    public AdminController( StorageService storageService ) {
        this.storageService = storageService;
    }

    @GetMapping( "/admin" )
    public String adminView( Model model, @AuthenticationPrincipal User user ) {
        model.addAttribute( "pageContext", new PageContext( "Admin page", "Nice description", user ) );
        model.addAttribute( "details", new AdminDetailDTO( storageService.getUsers() ) );
        return "admin";
    }

    @GetMapping( "/admin/user/{username}/edit" )
    public String adminView( Model model, @AuthenticationPrincipal User user, @PathVariable( "username" ) String username ) {
        Optional<User> optionalUser = storageService.getUserByName( username );

        if ( optionalUser.isEmpty() ) {
            return "redirect:/admin";
        }

        model.addAttribute( "user", optionalUser.get() );
        return "editUserForm";
    }

}