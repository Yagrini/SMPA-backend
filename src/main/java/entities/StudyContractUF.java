package entities;

import entities.composite_key.StudyContractUFCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studycontract_uf")
@NamedQueries(
        @NamedQuery(name = "UF.getByStudyContract",query = "SELECT sc.uf FROM StudyContractUF sc WHERE sc.studyContract.id = :id" )
)
public class StudyContractUF implements Serializable {

    @EmbeddedId
    StudyContractUFCK studyContractUFCK;

    @ManyToOne
    @MapsId("studyContractId")
    private StudyContract studyContract;

    @ManyToOne
    @MapsId("ufId")
    private UF uf;

    @ManyToOne
    @JoinColumn( name = "suggestion")
    private UF suggestion;

    public StudyContractUFCK getStudyContractUFCK() {
        return studyContractUFCK;
    }

    public void setStudyContractUFCK(StudyContractUFCK studyContractUFCK) {
        this.studyContractUFCK = studyContractUFCK;
    }

    public StudyContract getStudyContract() {
        return studyContract;
    }

    public void setStudyContract(StudyContract studyContract) {
        this.studyContract = studyContract;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public UF getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(UF suggestion) {
        this.suggestion = suggestion;
    }
}
