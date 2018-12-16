package controllers;
import controllers.filters.PasswordResetFilter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

public class ResponseBuilder {

	public static Response createResponse(String message) {
		Response response  = Response
								.status(Response.Status.UNAUTHORIZED)
								.entity(message)
								.build();
		return response;
	}
	public static Response createResponse( Response.Status status  ) {
		Response response  = Response
				.status(status)
				.build();
		return response;
	}
	public static Response createResponse( Response.Status status, String message) {
		Response response  = Response
				.status(status)
				.entity(message)
				.build();
		return response;
	}
	public static Response createResponse( Response.Status status, Map<String,Object> map, UriInfo uriInfo) {
		//System.out.println(requestContext.getUriInfo().getPath());
		//System.out.println(uriInfo.getBaseUriBuilder().path(ResetPassword.class).path(ResetPassword.class, "resetPassword"));
		Response response  = Response
				.created(uriInfo.getBaseUriBuilder().path(ResetPassword.class).path(ResetPassword.class, "resetPassword").build())
				.status(status)
				.header(PasswordResetFilter.AUTHORIZATION_PROPERTY, map.get(PasswordResetFilter.AUTHORIZATION_PROPERTY))
				.build();

		//System.out.println(response.getLink("updatePassword").getUri());
		return response;
	}
}
