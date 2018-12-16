package controllers;

import controllers.services.PasswordResetService;
import entities.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("reset")
public class ResetPassword {

    @POST
    @PermitAll
    @Path("uri")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String resetPasswordURI(@Context UriInfo uriInfo, String email){
        return  PasswordResetService.resetPasswordURI(uriInfo,email);
    }
    @POST
    @PermitAll
    @Path("updatePassword/{token}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User resetPassword(@PathParam("token") String token,User user){
        return  PasswordResetService.resetPassword(user);
    }
}
