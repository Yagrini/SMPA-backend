package models;

import entities.Administrator;

public class AdministratorDAO extends Model {

    private Model model = new Model();

    public void add(Administrator administrator) throws ExceptionDAO{
        try {
            model.getEm().getTransaction().begin();
            model.getEm().persist(administrator);
            model.getEm().getTransaction().commit();
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }
}
