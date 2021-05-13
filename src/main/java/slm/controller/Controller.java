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

    @GET
    @Path("/reload")
    @Produces(MediaType.TEXT_PLAIN)
    public String reload() {
        String output = Website.getJSON();
        return output;
    }

}
