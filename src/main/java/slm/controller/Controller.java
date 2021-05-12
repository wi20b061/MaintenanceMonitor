package slm.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/api/sample")
public class Controller {
    private static int counter=0;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String SampleMethod(){
        counter++;
        System.out.println("Call to GET");
        return "sample" + counter;
    }
    //funktioniert iwie nicht
    @GET
    @Path("/{delta}")
    @Produces(MediaType.TEXT_PLAIN)
    public String SampleMethodWithDelta(@PathParam("delta") int delta){
        counter = counter + delta;
        System.out.println("Call to POST");
        return "sample" + counter;
    }
}
