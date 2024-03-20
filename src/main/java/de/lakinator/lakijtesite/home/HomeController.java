package de.lakinator.lakijtesite.home;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.persistence.StorageService;
import de.lakinator.lakijtesite.persistence.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final StorageService storageService;

    public HomeController( StorageService storageService ) {
        this.storageService = storageService;
    }

    @GetMapping( "/" )
    public String rootView( Model model, @AuthenticationPrincipal User user ) {
        model.addAttribute( "pageContext", new PageContext( "Cool page", "Nice description", user ) );
        return "layout";
    }

    @GetMapping( "/visitors" )
    public String visitorView( Model model, @AuthenticationPrincipal User user ) {
        storageService.incrementVisitorCount();

        model.addAttribute( "pageContext", new PageContext( "Visitor page", "Here is the count of all page visitors", user ) );
        model.addAttribute( "visitorInfo", new VisitorInfoDTO( storageService.getVisitorCount() ) );
        return "visitors";
    }

}
