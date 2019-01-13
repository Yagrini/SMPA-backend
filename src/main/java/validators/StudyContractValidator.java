package validators;

import entities.StudyContract;

public class StudyContractValidator extends Validator{

    private static final String STARTDATE           = "startDate";
    private static final String ENDDATE             = "endDate";
    private static final String SEMESTER            = "semesterNbr";
    private static final String FIRSTSEMESTER       = "firstSemester";
    private static final String TYPE                = "type";

    public StudyContract createStudyContractValidation(StudyContract studyContract) {
        try {
            validateDate(studyContract.getStartDate().toString());
        } catch (Exception e) {
            addError(STARTDATE, e.getMessage());
        }
        try {
            validateDate(studyContract.getEndDate().toString());
        } catch (Exception e) {
            addError(ENDDATE, e.getMessage());
        }

        try {
            validateNumber(studyContract.getSemesterNbr().toString(), "semester");
        } catch (Exception e) {
            addError(SEMESTER, e.getMessage());
        }

        try {
            validateNumber(studyContract.getFirstSemester().toString(), "first semester");
        } catch (Exception e) {
            addError(FIRSTSEMESTER, e.getMessage());
        }

        try {
            validateType(studyContract.getType().toString());
        } catch (Exception e) {
            addError(TYPE, e.getMessage());
        }

        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return studyContract;
    }

    private void validateType(String type) throws Exception {
        if (type == null)
            throw new Exception("The field type is required.");

    }
}
