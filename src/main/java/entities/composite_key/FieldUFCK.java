package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FieldUFCK implements Serializable {

    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "uf_id")
    private Integer ufId;
}

