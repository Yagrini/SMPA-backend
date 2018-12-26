package resources;

import entities.*;
import models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@Path("")
public class TestDAO {

    @GET
    @Path("getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<University> getAll(){
        return new UniversityDAO().getUniversities();
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student add(Student student){
        return new StudentDAO().createStudent(student);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<UF> getItem(@PathParam("id") int id){
        return new UFDAO().getUFsByField(id);
    }

    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student update(Student student){
        return new StudentDAO().updateStudent(student);
    }

    @GET
    @Path("not/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<Notification> delete(@PathParam("id") int id){
        return new NotificationDAO().getNotificationByUser(id);
    }
}
