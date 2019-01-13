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
            throw new Exception("The field " + message + " is required");
    }

    protected void validateDate(String date) throws Exception {
        if (date == null)
            throw new Exception("The field date is required.");

    }
}
