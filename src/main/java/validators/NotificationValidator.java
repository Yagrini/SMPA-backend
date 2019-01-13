package validators;

import entities.Notification;

public class NotificationValidator extends Validator{

    private static final String OBJECT             = "object";
    private static final String MESSAGE            = "message";
    private static final String DATE          = "date";

    public Notification createNorificationValidation(Notification notification) {
        try {
            validateFields(notification.getObject(), "object");
        } catch (Exception e) {
            addError(OBJECT, e.getMessage());
        }

        try {
            validateFields(notification.getMessage(), "message");
        } catch (Exception e) {
            addError(MESSAGE, e.getMessage());
        }

        try {
            validateDate(notification.getDate().toString());
        } catch (Exception e) {
            addError(DATE, e.getMessage());
        }

        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return notification;
    }

    private void validateFields(String field, String message) throws Exception {
        if (field != null && field.length() < 4)
            throw new Exception("The "+ message +" must contain at least 4 characters.");
        else
            throw new Exception("The field "+ message +" is required");
    }
}
