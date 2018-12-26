package entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(referencedColumnName ="id")
@NamedQueries({
        @NamedQuery(name="Student.getAll", query="SELECT s FROM Student s")
})
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
    @Column(name = "level")
    private String level;

    @NotNull(message = "This field is required")
    @Pattern(regexp="^(?:33|0)\\s*[5|6](?:[\\s.-]*\\d{2}){4}$", message = "Invalid phone number")
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "student")
    @JsonbTransient
    private Collection<Application> universities;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "postal_code")
    private String postalCode;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "city")
    private String city;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "country")
    private String country;

    @OneToMany
    @JsonbTransient
    private Collection<Application> applications;

    @OneToMany
    @JsonbTransient
    private Collection<Review> reviews;

    @ManyToOne
    @JoinColumn( name = "field_id")
    private  Field field;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Application> getUniversities() {
        return universities;
    }

    public void setUniversities(Collection<Application> universities) {
        this.universities = universities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<Application> getApplications() {
        return applications;
    }

    public void setApplications(Collection<Application> applications) {
        this.applications = applications;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
