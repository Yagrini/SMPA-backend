package models;
import entities.University;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class UniversityDAO extends Model{
// get all
    public Collection<University> getUniversities() {
        Collection<University> universities = null;
        try {
            Query query = this.getEm().createNamedQuery("University.getAll");
            this.getEm().getTransaction().begin();
            universities = query.getResultList();
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return universities;
    }
// get by id
    public University getUniversity(int id) {
        University university = null;
        try {
            this.getEm().getTransaction().begin();
            university = this.getEm().find(University.class, id);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return university;
    }
// create
    public University createUniversity(University university) {
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(university);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return university;
    }
// update
    public University updateUniversity(University university) {
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(university);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return university;
    }
// delete
    public boolean deleteUniversity(int id) {
        try {
            this.getEm().getTransaction().begin();
            University university = this.getEm().find(University.class, id);
            this.getEm().remove(university);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return true;
    }

}
