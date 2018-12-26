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
}
