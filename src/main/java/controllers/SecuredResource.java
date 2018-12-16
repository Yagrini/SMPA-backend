package controllers;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@DeclareRoles({"Administrator", "Student", "University"})
@Path("secured")
public class SecuredResource {

    @GET
    @Path("everyone")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String everyoneMethod(){
        return "This message is for everyone !!";
    }

    @RolesAllowed({"Administrator"})
    @GET
    @Path("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String adminMethod(){
        return "This message is just for admins !!";
    }

    @RolesAllowed({"Administrator","Student"})
    @GET
    @Path("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String adminUserMethod(){
        return "This message is just for admins and users !!";
    }
}
