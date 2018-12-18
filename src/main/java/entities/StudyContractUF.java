package entities;

import entities.composite_key.StudyContractUFCK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studycontract_uf")
public class StudyContractUF implements Serializable {

    @EmbeddedId
    StudyContractUFCK studyContractUFCK;

    @ManyToOne
    @MapsId("studyContractId")
    private StudyContract studyContract;

    @ManyToOne
    @MapsId("ufId")
    private UF uf;

    @Column(name = "suggestion")
    private Integer suggestion;

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

    public Integer getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Integer suggestion) {
        this.suggestion = suggestion;
    }
}
