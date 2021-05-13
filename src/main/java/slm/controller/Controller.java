package slm.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/maintenance_monitor")
public class Controller {

    final String WHITESTYLE = "";
    final String REDSTYLE = "background: linear-gradient(90deg, rgb(255, 255, 255) 0%, rgba(245, 9, 9, 0.5) 50%, rgb(255, 255, 255) 100%)";
    final String GREENSTYLE = "background: linear-gradient(90deg, rgb(255, 255, 255) 0%, rgba(9, 245, 68, 0.5) 50%, rgb(255, 255, 255) 100%)";

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

    //https://docs.oracle.com/cd/E19798-01/821-1841/6nmq2cp1v/index.html
    @PUT
    @Path("/")
    @Consumes("application/x-www-form-urlencoded")
    public void changeMessage(@FormParam("message") String note) {
        Website.setMessage(note);
        Website.setStyle(REDSTYLE);
    }

    @PUT
    @Path("/reset")
    public void reset() {
        Website.setMessage("no information");
        Website.setStyle(WHITESTYLE);
    }

    @PUT
    @Path("/ok")
    public void setToOk() {
        Website.setMessage("");
        Website.setStyle(GREENSTYLE);
    }
}
