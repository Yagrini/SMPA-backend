package services.Authentication;

import entities.User;
import models.UserDAO;
import org.jose4j.jwt.consumer.InvalidJwtException;
import utils.Util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class AuthenticationService {

    public static final String AUTHORIZATION_PROPERTY = "x-access-token";

    public static String authenticate(User user, HttpServletRequest httpServletRequest){
        String errors = "";
        try {
            User dbUser = new UserDAO().selectUser(user.getEmail());
            String role = new UserDAO().selectRole(user.getEmail());
            if (dbUser == null) {
                errors += "No existent account !! ";
            } else {
                String hashPassword = Util.hashing(user.getPassword());
                if (!hashPassword.equals(dbUser.getPassword())) {
                    errors += "incorrect password !!";
                }
            }
            if(errors.equals("")){
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("user",dbUser);
                session.setAttribute("role", role);
                // generate a token for the user
                String token = PasswordResetService.generateJwtToken(user.getEmail());
                // write the token to the database
                new UserDAO().updateToken(user.getEmail(),token);
                return AUTHORIZATION_PROPERTY +"="+ token;
            }

        } catch (Exception e){
            System.out.println("User not found : " + user.getEmail());
        }
        return errors;
    }
    public static String logOut(ContainerRequestContext requestContext){
        // get request headers to extract jwt token
        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
        final List<String> authProperty = headers.get(AUTHORIZATION_PROPERTY);
        String jwt = authProperty.get(0);
        String email = null;
        try {
            email  = PasswordResetService.validateJwtToken(jwt);
        } catch (InvalidJwtException e) {
            return "Exception";
        }
        new UserDAO().updateToken(email, "");

        return "done";
    }
}
