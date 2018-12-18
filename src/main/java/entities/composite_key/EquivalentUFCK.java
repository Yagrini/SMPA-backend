package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EquivalentUFCK implements Serializable {

    @Column(name = "uf_id")
    private Integer ufId;

    @Column(name = "equivalent_uf_id")
    private Integer equivalentUFId;
}
