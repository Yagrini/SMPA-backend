package controllers.filters;

import javax.annotation.security.PermitAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@Provider
public class TokenResponseFilter implements ContainerResponseFilter {
    @Context
    private ResourceInfo resourceInfo;

    private static final String RESET_URL_PREFIX = "updatePassword";
    public static final String AUTHORIZATION_PROPERTY = "x-access-token";

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Method method = resourceInfo.getResourceMethod();

        //if( !(method.isAnnotationPresent( PermitAll.class ) || requestContext.getUriInfo().getPath().contains(RESET_URL_PREFIX)) )
        //{
            // get request headers to extract jwt token
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
            final List<String> authProperty = headers.get( AUTHORIZATION_PROPERTY );

            // block access if no authorization information is provided
            if( authProperty == null || authProperty.isEmpty() )
            {
                return;
            }
            String jwt = authProperty.get(0);
            responseContext.getHeaders().add(AUTHORIZATION_PROPERTY, jwt);
        //}
    }
}
