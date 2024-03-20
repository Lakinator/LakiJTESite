package de.lakinator.lakijtesite.login;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.persistence.model.User;
import jakarta.servlet.ServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping( "/login" )
    public String loginView( ServletRequest request, Model model, @AuthenticationPrincipal User user ) {
        if ( user != null ) {
            return "redirect:/";
        }

        boolean errorExists = request.getParameterMap().containsKey( "error" );
        model.addAttribute( "loginError", errorExists );

        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description", user ) );
        return "login";
    }

}
