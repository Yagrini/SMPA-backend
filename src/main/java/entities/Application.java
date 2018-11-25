package entities;

import entities.composite_key.StudentUniversityCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_university")
public class Application implements Serializable {

    @EmbeddedId
    StudentUniversityCK studentUniversityCK;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("universityId")
    private University university;

    @Column(name = "allow_access")
    private Boolean allowAccess;

    @Column(name = "accepted")
    private Boolean accepted = null;

    @Column(name = "canceled")
    private Boolean canceled;

    public StudentUniversityCK getStudentUniversityCK() {
        return studentUniversityCK;
    }

    public void setStudentUniversityCK(StudentUniversityCK studentUniversityCK) {
        this.studentUniversityCK = studentUniversityCK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Boolean getAllowAccess() {
        return allowAccess;
    }

    public void setAllowAccess(Boolean allowAccess) {
        this.allowAccess = allowAccess;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
}
