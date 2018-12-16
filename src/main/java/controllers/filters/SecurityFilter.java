package controllers.filters;

import controllers.ResponseBuilder;
import controllers.services.AuthenticationService;
import controllers.services.PasswordResetService;
import entities.User;
import models.UserDAO;
import org.jose4j.jwt.consumer.InvalidJwtException;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.util.*;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
    @Context
    private ResourceInfo resourceInfo;
    @Context
    private HttpServletRequest httpServletRequest;

    private static final String LOG_OUT_PREFIX = "logout";
    private static final String AUTHORIZATION_PROPERTY = "x-access-token";
    private static final String ACCESS_REFRESH = "Token expired. Please authenticate again!";
    private static final String ACCESS_INVALID_TOKEN = "Token invalid. Please authenticate again!";
    private static final String ACCESS_DENIED = "Not allowed to access this resource!";

    @Override
    public void filter( ContainerRequestContext requestContext ) {
        Method method = resourceInfo.getResourceMethod();
        if (!method.isAnnotationPresent(PermitAll.class)) {
            // get request headers to extract jwt token
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
            final List<String> authProperty = headers.get(AUTHORIZATION_PROPERTY);

            // block access if no authorization information is provided
            if (authProperty == null || authProperty.isEmpty()) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(Response.Status.UNAUTHORIZED, ACCESS_DENIED)
                );
                return;
            }

            String email = null;
            String jwt = authProperty.get(0);

            // try to decode the jwt - deny access if no valid token provided
            try {
                email = PasswordResetService.validateJwtToken(jwt);
            } catch (InvalidJwtException e) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(Response.Status.UNAUTHORIZED, ACCESS_INVALID_TOKEN)
                );
                return;
            }

            // check if token matches an user token (set in user/authenticate)
            User user = null;
            String role = null;
            try {
                user = new UserDAO().selectUser(email);
                role = new UserDAO().selectRole(email);
            } catch (Exception e) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(Response.Status.UNAUTHORIZED, ACCESS_DENIED)
                );
                return;
            }

            // token does not match with token stored in database - enforce re authentication
            if (!user.getRememberToken().equals(jwt)) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(Response.Status.UNAUTHORIZED, ACCESS_REFRESH)
                );
                return;
            }

            // verify user access from provided roles ("admin", "user", "guest")
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                if(requestContext.getUriInfo().getPath().contains(LOG_OUT_PREFIX)){
                    String message = AuthenticationService.logOut(requestContext);
                    requestContext.abortWith(
                            ResponseBuilder.createResponse(Response.Status.OK, message)
                    );
                    return;
                }
                // get annotated roles
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

                // user valid?
                if (!isUserAllowed(role, rolesSet)) {
                    requestContext.abortWith(
                            ResponseBuilder.createResponse(Response.Status.UNAUTHORIZED, ACCESS_DENIED)
                    );
                    return;
                }
            }
        }
    }
/*


            // nobody can access
            if( method.isAnnotationPresent( DenyAll.class ) )
            {
                requestContext.abortWith(
                        ResponseBuilder.createResponse( ACCESS_FORBIDDEN )
                );
                return;
            }

            String role = null ;

            // try to decode the jwt - deny access if no valid token provided
            try {
                HttpSession session = httpServletRequest.getSession();
                role = (String) session.getAttribute("role");
            } catch ( Exception e ) {
                requestContext.abortWith(
                        ResponseBuilder.createResponse(ACCESS_DENIED )
                );
                return;
            }

            // verify user access from provided roles
            if( method.isAnnotationPresent( RolesAllowed.class ) )
            {
                // get annotated roles
                RolesAllowed rolesAnnotation = method.getAnnotation( RolesAllowed.class );
                Set<String> rolesSet = new HashSet<String>( Arrays.asList( rolesAnnotation.value() ) );

                // user valid?
                if( !isUserAllowed(role, rolesSet ) )
                {
                    requestContext.abortWith(
                            ResponseBuilder.createResponse( ACCESS_DENIED )
                    );
                    return;
                }
            }
        }
    }*/
    private boolean isUserAllowed( final String userRole, final Set<String> rolesSet )
    {
        boolean isAllowed = false;

        if( rolesSet.contains( userRole ) )
        {
            isAllowed = true;
        }
        return isAllowed;
    }

}
