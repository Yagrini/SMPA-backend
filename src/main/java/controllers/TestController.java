package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestController {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object index() {

        return "It works !! ";
    }
}
