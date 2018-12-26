package entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "uf")
public class UF implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "code")
    private String code;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    @NotNull(message = "This field is required")
    @Column(name = "credit")
    private Integer credit;

    @NotNull(message = "This field is required")
    @Column(name = "hour_nbr")
    private Integer hourNbr;

    @NotNull(message = "This field is required")
    @Column(name = "semester")
    private Integer semester;

    @OneToMany(mappedBy = "uf")
    @JsonbTransient
    private Collection<FieldUF> fields;

    @OneToMany(mappedBy = "uf")
    @JsonbTransient
    private Collection<StudyContractUF> studyContracts;

    @OneToMany
    @JsonbTransient
    private Collection<Review> reviews;

    @OneToMany(mappedBy = "uf")
    private Collection<EquivalentUF> equivalentUF;

    @OneToMany(mappedBy = "equivalentUF")
    @JsonbTransient
    private Collection<EquivalentUF> uf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getHourNbr() {
        return hourNbr;
    }

    public void setHourNbr(Integer hourNbr) {
        this.hourNbr = hourNbr;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Collection<FieldUF> getFields() {
        return fields;
    }

    public void setFields(Collection<FieldUF> fields) {
        this.fields = fields;
    }

    public Collection<StudyContractUF> getStudyContracts() {
        return studyContracts;
    }

    public void setStudyContracts(Collection<StudyContractUF> studyContracts) {
        this.studyContracts = studyContracts;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public Collection<EquivalentUF> getEquivalentUF() {
        return equivalentUF;
    }

    public void setEquivalentUF(Collection<EquivalentUF> equivalentUF) {
        this.equivalentUF = equivalentUF;
    }

    public Collection<EquivalentUF> getUf() {
        return uf;
    }

    public void setUf(Collection<EquivalentUF> uf) {
        this.uf = uf;
    }
}
