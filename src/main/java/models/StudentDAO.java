package models;

import entities.Student;

import javax.persistence.Query;
import java.util.Collection;

public class StudentDAO extends Model {
// get all students
    public Collection<Student> getStudents(){
        Collection<Student> students = null;
        try{
            Query query = this.getEm().createNamedQuery("Student.getAll");
            this.getEm().getTransaction().begin();
            students = query.getResultList();
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
// get student by id
    public Student getStudent(int id){
        Student student = null;
        try {
            this.getEm().getTransaction().begin();
            student = this.getEm().find(Student.class, id);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(student.getApplications().size());
        return student;
    }
// create student
    public Student createStudent(Student student){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().persist(student);
            this.getEm().getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
// update student
    public Student updateStudent(Student student){
        try {
            this.getEm().getTransaction().begin();
            this.getEm().merge(student);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return student;
    }
// delete student
    public boolean deleteStudent(int id){
        try {
            this.getEm().getTransaction().begin();
            Student student = this.getEm().find(Student.class, id);
            this.getEm().remove(student);
            this.getEm().getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return true;
    }
}
