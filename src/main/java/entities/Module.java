package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "modules")
public class Module implements Serializable {

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
    @Column(name = "credits")
    private Integer credits;

    @NotNull(message = "This field is required")
    @Column(name = "hour_nbr")
    private Integer hourNbr;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;

    @Column(name = "accepted")
    private Boolean accepted = null;

    @OneToMany(mappedBy = "module")
    private Collection<FieldModule> fields;

    @ManyToMany
    private Collection<StudyContract> studyContracts;

    @OneToMany
    private Collection<Review> reviews;

    @OneToMany(mappedBy = "module")
    private Collection<EquivalentModule> modules;

    @OneToMany(mappedBy = "equivalentModule")
    private Collection<EquivalentModule> equivalentModules;

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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getHourNbr() {
        return hourNbr;
    }

    public void setHourNbr(Integer hourNbr) {
        this.hourNbr = hourNbr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Collection<FieldModule> getFields() {
        return fields;
    }

    public void setFields(Collection<FieldModule> fields) {
        this.fields = fields;
    }

    public Collection<StudyContract> getStudyContracts() {
        return studyContracts;
    }

    public void setStudyContracts(Collection<StudyContract> studyContracts) {
        this.studyContracts = studyContracts;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public Collection<EquivalentModule> getModules() {
        return modules;
    }

    public void setModules(Collection<EquivalentModule> modules) {
        this.modules = modules;
    }

    public Collection<EquivalentModule> getEquivalentModules() {
        return equivalentModules;
    }

    public void setEquivalentModules(Collection<EquivalentModule> equivalentModules) {
        this.equivalentModules = equivalentModules;
    }
}
