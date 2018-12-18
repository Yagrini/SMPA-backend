package resources;

import controllers.AuthenticationController;
import entities.Administrator;
import entities.User;
import models.AdministratorDAO;
import utils.Util;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@DeclareRoles({"Administrator", "Student", "University"})
@Path("auth")
public class AuthenticationResource {

    @Context private HttpServletRequest httpServletRequest;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public User index(){
        AuthenticationController authenticationController = new AuthenticationController();
        return authenticationController.index();
    }

    @POST
    @PermitAll
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(User user){
        AuthenticationController authenticationController = new AuthenticationController();
        return authenticationController.login(user, httpServletRequest);
    }

    @POST
    @RolesAllowed({"Administrator","Student", "University"})
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public void logout(){ }

    @POST
    @PermitAll
    @Path("generate-password-uri")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String generatePasswordURI(@Context UriInfo uriInfo, String email){
        AuthenticationController authenticationController = new AuthenticationController();
        return  authenticationController.generatePasswordURI(uriInfo,email);
    }

    @POST
    @PermitAll
    @Path("reset-password/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User resetPassword(@PathParam("token") String token,User user){
        AuthenticationController authenticationController = new AuthenticationController();
        return  authenticationController.reset_password(user);
    }

    @GET
    @PermitAll
    @Path("root")
    @Produces(MediaType.APPLICATION_JSON)
    public Administrator test(){
        AdministratorDAO administratorDAO = new AdministratorDAO();
        Administrator administrator = new Administrator();

        administrator.setEmail("admin@smpa.fr");
        administrator.setPassword(Util.hashing("root"));
        administrator.setCreated_at(Util.getCurrentDatetime());
        administrator.setPseudo("SMPA-ADMIN");

        administratorDAO.add(administrator);
        return administrator;
    }
}
