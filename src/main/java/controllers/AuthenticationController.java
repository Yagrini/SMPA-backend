package controllers;

import services.Authentication.AuthenticationService;
import services.Authentication.PasswordResetService;
import entities.User;
import models.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;

public class AuthenticationController {

    public User index() {
        User user = new UserDAO().selectUser("admin@smpa.fr");
        return user;
    }

    public String login(User user, HttpServletRequest httpServletRequest) {
        return  AuthenticationService.authenticate(user,httpServletRequest);
    }

    public User reset_password(User user) {
        return  PasswordResetService.resetPassword(user);
    }

    public String generatePasswordURI(UriInfo uriInfo, String email){
        return  PasswordResetService.resetPasswordURI(uriInfo,email);
    }
}
