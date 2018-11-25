package controllers;

import entities.Administrator;
import models.AdministratorDAO;
import utils.Util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("admin")
public class AdministratorController implements Controller {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object index() {
        AdministratorDAO administratorDAO = new AdministratorDAO();
        Administrator administrator = new Administrator();

        administrator.setEmail("admin@smpa.fr");
        administrator.setPassword(Util.hashing("root"));
        administrator.setCreated_at(Util.getCurrentDatetime());
        administrator.setPseudo("SMPA-ADMIN");

        administratorDAO.add(administrator);
        return administrator;
    }

    public Object create() {
        return null;
    }

    public Object store(Object request) {
        return null;
    }


    public Object show(int id) {
        return null;
    }

    public Object edit(int id) {
        return null;
    }

    public Object update(Object request, int id) {
        return null;
    }

    public Object destroy(int id) {
        return null;
    }
}
