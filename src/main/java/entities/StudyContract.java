package entities;

import enumerations.StudyContractEnum;

import javax.json.bind.annotation.JsonbTransient;
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
    private Integer firstSemester;

    @NotNull(message = "This field is required")
    @Enumerated(EnumType.STRING)
    private StudyContractEnum type;

    @Column(name = "accepted_by_student", nullable = true)
    private Boolean acceptedByStudent;

    @Column(name = "accepted_by_university", nullable = true)
    private Boolean acceptedByUniversity;

    @Column(name = "accepted_by_insa", nullable = true)
    private Boolean acceptedByINSA;

    @OneToOne
    @JoinColumn(name = "application_id")
    @JsonbTransient
    private Application application;

    @OneToMany(mappedBy = "studyContract")
    private Collection<StudyContractUF> studyContractUF;

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

    public Integer getFirstSemester() {
        return firstSemester;
    }

    public void setFirstSemester(Integer firstSemester) {
        this.firstSemester = firstSemester;
    }

    public StudyContractEnum getType() {
        return type;
    }

    public void setType(StudyContractEnum type) {
        this.type = type;
    }

    public Boolean getAcceptedByStudent() {
        return acceptedByStudent;
    }

    public void setAcceptedByStudent(Boolean acceptedByStudent) {
        this.acceptedByStudent = acceptedByStudent;
    }

    public Boolean getAcceptedByUniversity() {
        return acceptedByUniversity;
    }

    public void setAcceptedByUniversity(Boolean acceptedByUniversity) {
        this.acceptedByUniversity = acceptedByUniversity;
    }

    public Boolean getAcceptedByINSA() {
        return acceptedByINSA;
    }

    public void setAcceptedByINSA(Boolean acceptedByINSA) {
        this.acceptedByINSA = acceptedByINSA;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Collection<StudyContractUF> getStudyContractUF() {
        return studyContractUF;
    }

    public void setStudyContractUF(Collection<StudyContractUF> studyContractUF) {
        this.studyContractUF = studyContractUF;
    }
}
