package validators;

import entities.Administrator;
import utils.Util;

public class AdministratorValidator extends Validator{
    private static final String EMAIL            = "email";
    private static final String PSEUDO          = "pseudo";
    private static final String PASSWORD         = "password";
    private static final String CONFIRM_PASSWORD = "confirm_password";

    public Administrator createAdministratorValidation(Administrator administrator) {

        try {
            validateEmail(administrator.getEmail());
        } catch (Exception e) {
            addError(EMAIL, e.getMessage());
        }
        try {
            validatePassword( administrator.getPassword(), administrator.getConfirmPassword() );
        } catch ( Exception e ) {
            addError( PASSWORD, e.getMessage() );
        }

        administrator.setPassword(Util.hashing(administrator.getPassword()));

        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return administrator;
    }
    private void validateEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
                throw new Exception("Invalid email format.");
        }
        else
            throw new Exception("The field email is required");
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
