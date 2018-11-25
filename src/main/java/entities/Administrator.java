package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "administrators")
@PrimaryKeyJoinColumn(referencedColumnName ="id")
public class Administrator extends User implements Serializable {

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 100)
    @Column(name = "pseudo")
    private String pseudo;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
