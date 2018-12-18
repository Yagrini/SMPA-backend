package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "fields")
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn( name = "university_id")
    private University university;

    @OneToMany(mappedBy = "field")
    private Collection<FieldUF> uf;

    @OneToMany
    private Collection<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Collection<FieldUF> getUf() {
        return uf;
    }

    public void setUf(Collection<FieldUF> uf) {
        this.uf = uf;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
