package controllers;

import controllers.services.AuthenticationService;
import entities.User;
import models.UserDAO;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@PermitAll
@Path("authentication")
public class Authentication {
    @Context
    private HttpServletRequest httpServletRequest;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public User authenticate(){
        User user = new UserDAO().selectUser("admin@smpa.fr");
        return user;
    }

    @POST
    @PermitAll
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String authenticate(User user){
        return  AuthenticationService.authenticate(user,httpServletRequest);
    }

    @POST
    @RolesAllowed({"Administrator","Student", "University"})
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public void logout(){
        //return AuthenticationService.logOut(httpServletRequest);
    }
}
