package validators;

import entities.Student;
import utils.Util;
import validators.Validator;

import javax.servlet.http.HttpServletRequest;

public class StudentValidator extends Validator {

    private static final String FIRST_NAME       = "first_name";
    private static final String LAST_NAME        = "last_name";
    private static final String EMAIL            = "email";
    private static final String PICTURE          = "picture";
    private static final String SEX              = "sex";
    private static final String BIRTH_DATE       = "birth_date";
    private static final String LEVEL            = "level";
    private static final String FIELD_NAME       = "field_name";
    private static final String PASSWORD         = "password";
    private static final String CONFIRM_PASSWORD = "confirm_password";

    public Student createStudent(HttpServletRequest request) {
        Student student         = new Student();
        String first_name       = getFieldValue(request, FIRST_NAME);
        String last_name        = getFieldValue(request, LAST_NAME);
        String email            = getFieldValue(request, EMAIL);
        String picture          = getFieldValue(request, PICTURE);
        String sex              = getFieldValue(request, SEX);
        String birth_date       = getFieldValue(request, BIRTH_DATE);
        String level            = getFieldValue(request, LEVEL);
        String field_name       = getFieldValue(request, FIELD_NAME);
        String password         = getFieldValue(request, PASSWORD);
        String confirm_password = getFieldValue(request, CONFIRM_PASSWORD);

        try {
            validateFirstName(first_name);
        } catch (Exception e) {
            addError(FIRST_NAME, e.getMessage());
        }

        try {
            validateLastName(last_name);
        } catch (Exception e) {
            addError(LAST_NAME, e.getMessage());
        }

        try {
            validateEmail(email);
        } catch (Exception e) {
            addError(EMAIL, e.getMessage());
        }

        try {
            validatePassword( password, confirm_password );
        } catch ( Exception e ) {
            addError( PASSWORD, e.getMessage() );
        }

        student.setFirstName(first_name);
        student.setLastName(last_name);
        student.setEmail(email);
        student.setPassword(Util.hashing(password));


        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return student;
    }

    private void validateFirstName(String first_name) throws Exception {
        if (first_name != null && first_name.length() < 3)
            throw new Exception("The first name must contain at least 3 characters.");
    }

    private void validateLastName(String last_name) throws Exception {
        if (last_name != null && last_name.length() < 3)
            throw new Exception("The last name must contain at least 3 characters.");
    }

    private void validateEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
                throw new Exception("Please enter a valid email address.");
        }
        else
            throw new Exception("Please enter an email address.");
    }

    private void validatePassword(String password, String confirm_password) throws Exception {
        if (password != null && confirm_password != null) {
            if (!password.equals(confirm_password))
                throw new Exception("Password and confirmation password are different, please enter them again.");
            else if (password.length() < 2)
                throw new Exception("Passwords must contain at least 2 characters.");
        }
        else
            throw new Exception("Please enter and confirm your password.");
    }
}
