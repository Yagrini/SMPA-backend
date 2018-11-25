package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EquivalentModuleCK implements Serializable {

    @Column(name = "module_id")
    private Integer moduleId;

    @Column(name = "equivalent_module_id")
    private Integer equivalentModuleId;
}
