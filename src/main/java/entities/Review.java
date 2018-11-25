package entities;

import enumerations.SessionEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "This field is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @NotNull(message = "This field is required")
    @Column(name = "note")
    private Float note;

    @Column(name = "percent", nullable = true)
    private Float percent;

    @NotNull(message = "This field is required")
    @Column(name = "semester")
    private Integer semester;

    @NotNull(message = "This field is required")
    @Column(name = "session")
    private SessionEnum session;

    @Column(name = "validated", nullable = true)
    private Boolean validated;

    @Column(name = "insa")
    private Boolean insa;

    @ManyToOne
    @JoinColumn( name = "idStudent")
    private Student student;

    @ManyToOne
    @JoinColumn( name = "idModule")
    private Module module;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public SessionEnum getSession() {
        return session;
    }

    public void setSession(SessionEnum session) {
        this.session = session;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Boolean getInsa() {
        return insa;
    }

    public void setInsa(Boolean insa) {
        this.insa = insa;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}