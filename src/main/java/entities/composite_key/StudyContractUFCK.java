package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudyContractUFCK implements Serializable {

    @Column(name = "studyContract_id")
    private Integer studyContractId;

    @Column(name = "uf_id")
    private Integer ufId;
}
