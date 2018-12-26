package models;

import entities.Application;

import javax.persistence.Query;
import java.util.Collection;

public class ApplicationDAO extends Model{

// get applications by university
    public Collection<Application> getAppsByUniversity(int id){
        Collection<Application> applications = null;
        try {
            Query query = this.getEm().createNamedQuery("Application.getByUniversity");
            query.setParameter("id", id);
            this.getEm().getTransaction().begin();
            applications = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return applications;
    }
// get applications by student
    public Collection<Application> getAppsByStudent(int id){
        Collection<Application> applications = null;
        try {
            Query query = this.getEm().createNamedQuery("Application.getByStudent");
            query.setParameter("id", id);
            this.getEm().getTransaction().begin();
            applications = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return applications;
    }
// get application by id
    public Application getApplication(int id){
        Application application = null;
        try {
            this.getEm().getTransaction().begin();
            application = this.getEm().find(Application.class, id);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return application;
    }
// create application
    public Application createApplication(Application application){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(application);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return application;
    }
// update application
    public Application updateApplication(Application application){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(application);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return application;
    }
}
