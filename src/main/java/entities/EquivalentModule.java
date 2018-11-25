package entities;

import entities.composite_key.EquivalentModuleCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equivalent_module")
public class EquivalentModule implements Serializable {

    @EmbeddedId
    EquivalentModuleCK equivalentModuleCK;

    @ManyToOne
    @MapsId("moduleId")
    private Module module;

    @ManyToOne
    @MapsId("equivalentModuleId")
    private Module equivalentModule;

    public EquivalentModuleCK getEquivalentModuleCK() {
        return equivalentModuleCK;
    }

    public void setEquivalentModuleCK(EquivalentModuleCK equivalentModuleCK) {
        this.equivalentModuleCK = equivalentModuleCK;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getEquivalentModule() {
        return equivalentModule;
    }

    public void setEquivalentModule(Module equivalentModule) {
        this.equivalentModule = equivalentModule;
    }
}
