package validators;

import entities.Field;

public class FieldValidator extends Validator{

    private static final String NAME = "name";

    public Field createFieldValidation(Field field) {
        try {
            validateName(field.getName());
        } catch (Exception e) {
            addError(NAME, e.getMessage());
        }
        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return field;
    }

    private void validateName(String name) throws Exception {
        if (name != null && name.length() < 4)
            throw new Exception("The name must contain at least 4 characters.");
        else
            throw new Exception("The field name is required");
    }
}
