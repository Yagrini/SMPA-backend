package entities;

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
    @Column(name = "normal_session_note")
    private Float normalSessionNote;

    @NotNull(message = "This field is required")
    @Column(name = "retake_session_note")
    private Float RetakeSessionNote = null;

    @Column(name = "valid", nullable = true)
    private Boolean valid;

    @ManyToOne
    @JoinColumn( name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn( name = "uf_id")
    private UF uf;

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

    public Float getNormalSessionNote() {
        return normalSessionNote;
    }

    public void setNormalSessionNote(Float normalSessionNote) {
        this.normalSessionNote = normalSessionNote;
    }

    public Float getRetakeSessionNote() {
        return RetakeSessionNote;
    }

    public void setRetakeSessionNote(Float retakeSessionNote) {
        RetakeSessionNote = retakeSessionNote;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}