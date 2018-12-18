package filters;

import resources.ResponseBuilder;
import services.Authentication.PasswordResetService;
import entities.User;
import models.UserDAO;
import org.jose4j.jwt.consumer.InvalidJwtException;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class PasswordResetFilter implements ContainerRequestFilter {

    private static final String RESET_URL_PREFIX = "reset-password";
    public static final String AUTHORIZATION_PROPERTY = "x-access-token";

    // Do not use static responses, rebuild responses every time
    private static final String ACCESS_REFRESH = "Token expired.";
    private static final String ACCESS_INVALID_TOKEN = "Token invalid.";
    private static final String ACCESS_DENIED = "Not allowed to access this resource!";


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(requestContext.getUriInfo().getPath().contains(RESET_URL_PREFIX)) {

            // get request headers to extract jwt token
            String email = null;
            String jwt = requestContext.getUriInfo().getPath().split("/")[2];

            // try to decode the jwt - deny access if no valid token provided
            try {
                email = PasswordResetService.validateJwtToken(jwt);
            } catch (InvalidJwtException e) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(ACCESS_INVALID_TOKEN)
                );
                return;
            }

            // check if token matches an user token (set in user/authenticate)
            User user = null;
            try {
                user = new UserDAO().selectUser(email);
            } catch (Exception e) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(ACCESS_DENIED)
                );
                return;
            }

            // token does not match with token stored in database - enforce re authentication
            if (!user.getRememberToken().equals(jwt)) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(ACCESS_REFRESH)
                );
                return;
            }
        }
    }
}
