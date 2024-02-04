package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.persistence.model.User;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    Map<Integer, String> errorCodeMap = Map.of( 123, "Could not persist new user!", 124, "User already logged in!" ); // TODO: custom enum

    @RequestMapping( "/error" )
    public String handleError( Model model, @AuthenticationPrincipal User user, @RequestParam Integer code ) {
        model.addAttribute( "pageContext", new PageContext( "Error page", "This is the default error page", user ) );
        model.addAttribute( "errorMsg", errorCodeMap.getOrDefault( code, "No corresponding error found" ) );
        return "error";
    }

}
