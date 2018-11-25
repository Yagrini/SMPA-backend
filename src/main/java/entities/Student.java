package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(referencedColumnName ="id")
public class Student extends User implements Serializable {

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "This field is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Size(min = 1, max = 100)
    @Column(name = "picture", nullable = true)
    private String picture;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "sex")
    private String sex;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "field_name")
    private String fieldName;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "student")
    private Collection<Application> universities;

    @OneToOne
    private StudyContract studyContract;

    @OneToMany
    private Collection<Review> reviews;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Collection<Application> getUniversities() {
        return universities;
    }

    public void setUniversities(Collection<Application> universities) {
        this.universities = universities;
    }

    public StudyContract getStudyContract() {
        return studyContract;
    }

    public void setStudyContract(StudyContract studyContract) {
        this.studyContract = studyContract;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }
}
