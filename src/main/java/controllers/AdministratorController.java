package controllers;

import entities.Administrator;
import models.AdministratorDAO;
import utils.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("admin")
public class AdministratorController implements Controller {

    @Context
    private HttpServletRequest httpRequest;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object index() {
        HttpSession session = httpRequest.getSession();
        session.setAttribute("younes", "bekkay");

        AdministratorDAO administratorDAO = new AdministratorDAO();
        Administrator administrator = new Administrator();

        administrator.setEmail("adminoo@smpa.fr");
        administrator.setPassword(Util.hashing("root"));
        administrator.setCreated_at(Util.getCurrentDatetime());
        administrator.setPseudo("SMPA-ADMIN");

        administratorDAO.add(administrator);

        System.out.println(session.getAttribute("younes"));
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
