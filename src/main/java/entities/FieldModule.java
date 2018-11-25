package entities;

import entities.composite_key.FieldModuleCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "field_module")
public class FieldModule implements Serializable {

    @EmbeddedId
    FieldModuleCK fieldModuleCK;

    @ManyToOne
    @MapsId("fieldId")
    private Field field;

    @ManyToOne
    @MapsId("moduleId")
    private Module module;

    @Column(name = "optional")
    private Boolean optional;

    public FieldModuleCK getFieldModuleCK() {
        return fieldModuleCK;
    }

    public void setFieldModuleCK(FieldModuleCK fieldModuleCK) {
        this.fieldModuleCK = fieldModuleCK;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }
}
