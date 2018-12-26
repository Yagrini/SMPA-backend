package validators;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    protected String  result;
    protected Map<String, String> errors = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void addError(String field, String message ) {
        errors.put( field, message );
    }

    public String getFieldValue(HttpServletRequest request, String field ) {
        String value = request.getParameter( field );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value.trim();
        }
    }

    protected void validateNumber(String number, String message) throws Exception {
        if (number != null) {
            if (!number.matches( "(\\d+)"))
                throw new Exception("Please enter a valid " + message + ".");
        }
        else
            throw new Exception("Please enter an email address.");
    }

    protected void validateEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
                throw new Exception("Please enter a valid email address.");
        }
        else
            throw new Exception("Please enter an email address.");
    }

    protected void validatePassword(String password, String confirm_password) throws Exception {
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
