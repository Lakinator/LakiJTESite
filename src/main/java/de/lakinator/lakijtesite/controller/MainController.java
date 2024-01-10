package de.lakinator.lakijtesite.controller;

import de.lakinator.lakijtesite.model.PageContext;
import de.lakinator.lakijtesite.model.VisitorInfo;
import de.lakinator.lakijtesite.persistence.DataRoot;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute( "visitorInfo", new VisitorInfo( dataRoot.getVisitorCount() ) );
        return "visitors";
    }

}
