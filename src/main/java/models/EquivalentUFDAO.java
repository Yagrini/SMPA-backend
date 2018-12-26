package models;

import entities.EquivalentUF;

public class EquivalentUFDAO extends Model{
// create equivalent UF
    public EquivalentUF createEquivalentUF(EquivalentUF equivalentUF){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(equivalentUF);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return equivalentUF;
    }
// update equivalent UF
    public EquivalentUF updateEquivalentUF(EquivalentUF equivalentUF){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(equivalentUF);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return equivalentUF;
    }
// delete equivalent UF
    public boolean deleteEquivalentUF(int id){
        try {
            this.getEm().getTransaction().begin();
            EquivalentUF equivalentUF = this.getEm().find(EquivalentUF.class, id);
            this.getEm().remove(equivalentUF);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
