package validators;

import entities.Student;
import entities.University;
import utils.Util;

import javax.servlet.http.HttpServletRequest;

public class UniversityValidator extends Validator {

    private static final String NAME       = "name";
    private static final String EMAIL            = "email";
    private static final String PICTURE          = "picture";
    private static final String ADDRESS        = "address";
    private static final String POSTALCODE              = "postalCode";
    private static final String CITY       = "city";
    private static final String COUNTRY            = "country";
    private static final String DESCRIPTION       = "description";
    private static final String PHONE       = "phone";
    private static final String PASSWORD         = "password";
    private static final String CONFIRM_PASSWORD = "confirm_password";

    public University createUniversity(HttpServletRequest request) {
        University university = new University();
        String name       = getFieldValue(request, NAME);
        String email        = getFieldValue(request, EMAIL);
        String picture            = getFieldValue(request, PICTURE);
        String address          = getFieldValue(request, ADDRESS);
        String postalcode              = getFieldValue(request, POSTALCODE);
        String city       = getFieldValue(request, CITY);
        String country            = getFieldValue(request, COUNTRY);
        String description       = getFieldValue(request, DESCRIPTION);
        String phone       = getFieldValue(request, PHONE);
        String password         = getFieldValue(request, PASSWORD);
        String confirm_password = getFieldValue(request, CONFIRM_PASSWORD);

        try {
            validateName(name);
        } catch (Exception e) {
            addError(name, e.getMessage());
        }

        try {
            validateEmail(email);
        } catch (Exception e) {
            addError(EMAIL, e.getMessage());
        }

        try {
            validatePhone(phone);
        } catch (Exception e) {
            addError(PHONE, e.getMessage());
        }

        try {
            validateDescription(description);
        } catch (Exception e) {
            addError(name, e.getMessage());
        }

        try {
            validateNumber(postalcode, "postal code");
        } catch (Exception e) {
            addError(name, e.getMessage());
        }

        try {
            validatePassword( password, confirm_password );
        } catch ( Exception e ) {
            addError( PASSWORD, e.getMessage() );
        }

        university.setName(name);
        university.setPhone(phone);
        university.setEmail(email);
        university.setPassword(Util.hashing(password));


        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return university;
    }

    private void validateDescription(String description) throws Exception {
        if (description != null && description.length() < 10)
            throw new Exception("The name must contain at least 10 characters.");
    }

    private void validateName(String name) throws Exception {
        if (name != null && name.length() < 3)
            throw new Exception("The name must contain at least 3 characters.");
    }

    private void validatePhone(String phone) throws Exception {
        if (phone != null) {
            if (!phone.matches( "^(?:33|0)\\s*[5|6](?:[\\s.-]*\\d{2}){4}$"))
                throw new Exception("Please enter a valid phone number.");
        }
        else
            throw new Exception("Please enter an phone number.");
    }
}
