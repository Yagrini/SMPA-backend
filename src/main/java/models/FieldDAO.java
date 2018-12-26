package models;

import entities.Field;

import javax.persistence.Query;
import java.util.Collection;

public class FieldDAO extends Model {

// get fields by university
    public Collection<Field> getFieldsByUniversity(int id){
        Collection<Field> fields = null;
        try {
            Query query = this.getEm().createNamedQuery("Field.getByUniversity");
            query.setParameter("id", id);
            this.getEm().getTransaction().begin();
            fields = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return fields;
    }
// get by id
    public Field getField(int id) {
        Field field = null;
        try {
            this.getEm().getTransaction().begin();
            field = this.getEm().find(Field.class, id);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return field;
    }
// create
    public Field createField(Field field) {
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(field);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return field;
    }
// update
    public Field updateField(Field field) {
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(field);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return field;
    }
// delete
    public boolean deleteField(int id) {
        try {
            this.getEm().getTransaction().begin();
            Field field = this.getEm().find(Field.class, id);
            this.getEm().remove(field);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
