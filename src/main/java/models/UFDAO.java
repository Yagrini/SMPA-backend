package models;

import entities.FieldUF;
import entities.UF;

import javax.persistence.Query;
import java.util.Collection;

public class UFDAO extends Model {

// get UFs by Field
    public Collection<UF> getUFsByField(int id){
        Collection<UF> ufs = null;
        try {
            Query query = this.getEm().createNamedQuery("UF.getByField");
            query.setParameter("id", id);
            this.getEm().getTransaction().begin();
            ufs = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ufs;
    }
// get UFs by StudyContract
    public Collection<UF> getUFsByStudyContract(int id){
        Collection<UF> ufs = null;
        try {
            Query query = this.getEm().createNamedQuery("UF.getByStudyContract");
            query.setParameter("id", id);
            this.getEm().getTransaction().begin();
            ufs = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ufs;
    }
// get UF ( UF equivalent is wrapped in UF)
    public UF getUF(int id){
        UF uf = null;
        try {
            this.getEm().getTransaction().begin();
            uf = this.getEm().find(UF.class, id);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return uf;
    }
// create UF
    // Remark :
    //To create/ update or delete all fieldUFs associated to this uf we just need to add CASCADE in UF entity before Collection<FieldUF>.
    public UF createUF(UF uf) {
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(uf);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return uf;
    }
// update UF
    public UF updateUF(UF uf) {
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(uf);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return uf;
    }
// delete UF
    public boolean deleteUF(int id) {
        try {
            this.getEm().getTransaction().begin();
            UF uf = this.getEm().find(UF.class, id);
            this.getEm().remove(uf);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
