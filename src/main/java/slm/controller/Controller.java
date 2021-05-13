package slm.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/maintenance_monitor")
public class Controller {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String returnHTML() {
        return Website.getHTML();
    }

}
