package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FieldModuleCK implements Serializable {

    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "module_id")
    private Integer moduleId;
}
