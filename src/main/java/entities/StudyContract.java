package entities;

import enumerations.StudyContractEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "studycontracts")
public class StudyContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "This field is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = "This field is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @NotNull(message = "This field is required")
    @Column(name = "semester_nbr")
    private Integer semesterNbr;

    @NotNull(message = "This field is required")
    @Column(name = "first_semester")
    private Integer first_semester;

    @NotNull(message = "This field is required")
    @Enumerated(EnumType.STRING)
    private StudyContractEnum type;

    @Column(name = "accepted", nullable = true)
    private Boolean accepted;

    @NotNull(message = "This field is required")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @OneToOne
    @JoinColumn(name = "idStudent")
    private Student student;

    @ManyToMany
    private Collection<Module> modules;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSemesterNbr() {
        return semesterNbr;
    }

    public void setSemesterNbr(Integer semesterNbr) {
        this.semesterNbr = semesterNbr;
    }

    public Integer getFirst_semester() {
        return first_semester;
    }

    public void setFirst_semester(Integer first_semester) {
        this.first_semester = first_semester;
    }

    public StudyContractEnum getType() {
        return type;
    }

    public void setType(StudyContractEnum type) {
        this.type = type;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Collection<Module> getModules() {
        return modules;
    }

    public void setModules(Collection<Module> modules) {
        this.modules = modules;
    }
}
