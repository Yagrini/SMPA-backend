package resources;
import javax.ws.rs.core.Response;


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
}
