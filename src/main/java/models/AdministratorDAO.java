package models;

import entities.Administrator;

public class AdministratorDAO extends Model {

    public void add(Administrator administrator) throws ExceptionDAO{
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(administrator);
            this.getEm().getTransaction().commit();
        } catch (Exception e) {
            throw new ExceptionDAO(e);
        }
    }
// update Administrator
    public Administrator updateEquivalentUF(Administrator administrator){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(administrator);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return administrator;
    }
}
