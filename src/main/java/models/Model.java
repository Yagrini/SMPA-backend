package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Model {

    EntityManager em;

    public Model() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMPA-PU");
        this.em = emf.createEntityManager();
    }

    public Model(String persistanceUnitName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistanceUnitName);
        this.em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
