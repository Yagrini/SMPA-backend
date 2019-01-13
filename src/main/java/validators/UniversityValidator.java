package validators;

import entities.Student;
import entities.University;
import utils.Util;

import javax.servlet.http.HttpServletRequest;

public class UniversityValidator extends Validator {

    private static final String NAME             = "name";
    private static final String EMAIL            = "email";
    private static final String PICTURE          = "picture";
    private static final String PHONE            = "phone";
    private static final String DESCRIPTION      = "description";
    private static final String ADDRESS          = "address";
    private static final String POSTALCODE       = "postalCode";
    private static final String CITY             = "city";
    private static final String COUNTRY          = "country";
    private static final String PASSWORD         = "password";
    private static final String CONFIRM_PASSWORD = "confirm_password";

    public University createUniversityValidation(University university) {
        try {
            validateName(university.getName());
        } catch (Exception e) {
            addError(NAME, e.getMessage());
        }

        try {
            validateEmail(university.getEmail());
        } catch (Exception e) {
            addError(EMAIL, e.getMessage());
        }

        try {
            validatePhone(university.getPhone());
        } catch (Exception e) {
            addError(PHONE, e.getMessage());
        }

        try {
            validateDescription(university.getDescription());
        } catch (Exception e) {
            addError(DESCRIPTION, e.getMessage());
        }

        try {
            validateAddress(university.getAddress());
        } catch (Exception e) {
            addError(ADDRESS, e.getMessage());
        }

        try {
            validatePostalCode(university.getPostalCode());
        } catch (Exception e) {
            addError(POSTALCODE, e.getMessage());
        }

        try {
            validateCity(university.getCity());
        } catch (Exception e) {
            addError(CITY, e.getMessage());
        }

        try {
            validateCountry(university.getCountry());
        } catch (Exception e) {
            addError(COUNTRY, e.getMessage());
        }

        try {
            validatePassword( university.getPassword(), university.getConfirmPassword() );
        } catch ( Exception e ) {
            addError( PASSWORD, e.getMessage() );
        }

        university.setPassword(Util.hashing(university.getPassword()));


        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return university;
    }

    private void validateName(String name) throws Exception {
        if (name != null && name.length() < 4)
            throw new Exception("The name must contain at least 4 characters.");
    }

    private void validateEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
                throw new Exception("Invalid email format.");
        }
        else
            throw new Exception("The field email is required");
    }

    private void validatePhone(String phone) throws Exception {
        if (phone.length() == 0)
            throw new Exception("The field phone is required");
    }

    private void validateDescription(String description) throws Exception {
        if (description.length() == 0)
            throw new Exception("The field description is required");
    }

    private void validateAddress(String address) throws Exception {
        if (address.length() == 0)
            throw new Exception("The field address is required");
    }

    private void validatePostalCode(String postalCode) throws Exception {
        if (postalCode.length() == 0)
            throw new Exception("The field postal code is required");
    }

    private void validateCity(String city) throws Exception {
        if (city.length() == 0)
            throw new Exception("The field city is required");
    }

    private void validateCountry(String country) throws Exception {
        if (country.length() == 0)
            throw new Exception("The field country is required");
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
