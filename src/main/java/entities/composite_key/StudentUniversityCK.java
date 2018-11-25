package entities.composite_key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentUniversityCK implements Serializable {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "university_id")
    private Integer universityId;
}
