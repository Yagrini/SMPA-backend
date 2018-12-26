package entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "universities")
@PrimaryKeyJoinColumn(referencedColumnName ="id")
@NamedQueries({
        @NamedQuery(name="University.getAll", query="SELECT u FROM University u")
})
public class University extends User implements Serializable {

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    @Size(min = 1, max = 100)
    @Column(name = "picture", nullable = true)
    private String picture;

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

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;

    @NotNull(message = "This field is required")
    @Pattern(regexp="^(?:33|0)\\s*[5|6](?:[\\s.-]*\\d{2}){4}$", message = "Invalid phone number")
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "university")
    @JsonbTransient
    private Collection<Application> applications;

    @OneToMany
    @JsonbTransient
    private Collection<Field> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Application> getApplications() {
        return applications;
    }

    public void setApplications(Collection<Application> applications) {
        this.applications = applications;
    }

    public Collection<Field> getFields() {
        return fields;
    }

    public void setFields(Collection<Field> fields) {
        this.fields = fields;
    }
}
