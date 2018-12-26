package entities;

import entities.composite_key.FieldUFCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "field_uf")
@NamedQueries({
        @NamedQuery(name = "UF.getByField", query = "SELECT f.uf FROM FieldUF f WHERE f.field.id = :id")
})
public class FieldUF implements Serializable {

    @EmbeddedId
    FieldUFCK fieldUFCK;

    @ManyToOne
    @MapsId("fieldId")
    private Field field;

    @ManyToOne
    @MapsId("ufId")
    private UF uf;

    @Column(name = "optional")
    private Boolean optional;

    public FieldUFCK getFieldUFCK() {
        return fieldUFCK;
    }

    public void setFieldUFCK(FieldUFCK fieldUFCK) {
        this.fieldUFCK = fieldUFCK;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }
}
