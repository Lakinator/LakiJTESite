package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.PageContext;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping( "/error" )
    public String handleError( Model model ) {
        model.addAttribute( "pageContext", new PageContext( "Error page", "This is the default error page" ) );
        return "error";
    }

}
