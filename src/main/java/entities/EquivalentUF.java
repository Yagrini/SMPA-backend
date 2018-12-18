package entities;

import entities.composite_key.EquivalentUFCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equivalent_uf")
public class EquivalentUF implements Serializable {

    @EmbeddedId
    EquivalentUFCK equivalentUFCK;

    @ManyToOne
    @MapsId("ufId")
    private UF uf;

    @ManyToOne
    @MapsId("equivalentUFId")
    private UF equivalentUF;

    public EquivalentUFCK getEquivalentUFCK() {
        return equivalentUFCK;
    }

    public void setEquivalentUFCK(EquivalentUFCK equivalentUFCK) {
        this.equivalentUFCK = equivalentUFCK;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public UF getEquivalentUF() {
        return equivalentUF;
    }

    public void setEquivalentUF(UF equivalentUF) {
        this.equivalentUF = equivalentUF;
    }
}

