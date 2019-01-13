package validators;
import entities.UF;

public class UFValidator extends Validator {

    private static final String CODE             = "code";
    private static final String NAME            = "name";
    private static final String CREDIT          = "credit";
    private static final String HOURNB            = "hourNbr";
    private static final String SEMESTER      = "semester";

    public UF createUFValidation(UF uf) {
        try {
            validateName(uf.getCode());
        } catch (Exception e) {
            addError(CODE, e.getMessage());
        }

        try {
            validateName(uf.getName());
        } catch (Exception e) {
            addError(NAME, e.getMessage());
        }

        try {
            validateNumber(uf.getCredit().toString(), "credit");
        } catch (Exception e) {
            addError(CREDIT, e.getMessage());
        }
        try {
            validateNumber(uf.getHourNbr().toString(), "hour number");
        } catch (Exception e) {
            addError(HOURNB, e.getMessage());
        }

        try {
            validateNumber(uf.getSemester().toString(), "semester");
        } catch (Exception e) {
            addError(SEMESTER, e.getMessage());
        }

        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return uf;
    }

    private void validateName(String name) throws Exception {
        if (name != null && name.length() < 4)
            throw new Exception("The name must contain at least 4 characters.");
        else
            throw new Exception("The field name is required");
    }
}
