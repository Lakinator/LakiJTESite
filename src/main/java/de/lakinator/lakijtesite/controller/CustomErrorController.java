package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.PageContext;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    Map<Integer, String> errorCodeMap = Map.of( 123, "Could not persist new user!" ); // TODO: custom enum

    @RequestMapping( "/error" )
    public String handleError( Model model, @RequestParam int code ) {
        model.addAttribute( "pageContext", new PageContext( "Error page", "This is the default error page" ) );
        model.addAttribute( "errorMsg", errorCodeMap.getOrDefault( code, "No corresponding error" ) );
        return "error";
    }

}
