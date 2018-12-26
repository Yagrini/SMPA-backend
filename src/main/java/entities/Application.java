package entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "applications")
@NamedQueries({
        @NamedQuery(name = "Application.getByUniversity", query = "SELECT a FROM Application a WHERE a.university.id = :id"),
        @NamedQuery(name = "Application.getByStudent", query = "SELECT a FROM Application a WHERE a.student.id = :id")
})
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "allow_access")
    private Boolean allowAccess;

    @ManyToOne
    @JoinColumn( name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn( name = "university_id")
    private University university;

    @OneToOne StudyContract studyContract;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAllowAccess() {
        return allowAccess;
    }

    public void setAllowAccess(Boolean allowAccess) {
        this.allowAccess = allowAccess;
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

    public StudyContract getStudyContract() {
        return studyContract;
    }

    public void setStudyContract(StudyContract studyContract) {
        this.studyContract = studyContract;
    }
}
