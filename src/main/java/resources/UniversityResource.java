package resources;

import controllers.UniversityController;
import entities.University;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@DeclareRoles({"Administrator", "Student", "University"})
@Path("university")
public class UniversityResource {

    @Context
    private HttpServletRequest httpServletRequest;

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<University> index(){
        UniversityController universityController = new UniversityController();
        return universityController.index();
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object store(University university){
        UniversityController universityController = new UniversityController();
        return universityController.store(university);
    }
}
