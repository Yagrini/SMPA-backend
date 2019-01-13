package validators;

import entities.Review;

public class ReviewValidator extends Validator{

    private static final String DATE                  = "date";
    private static final String NORMALNOTE            = "normalSessionNote";

    public Review createReviewValidation(Review review) {
        try {
            validateDate(review.getDate().toString());
        } catch (Exception e) {
            addError(DATE, e.getMessage());
        }

        try {
            validateNote(review.getNormalSessionNote().toString());
        } catch (Exception e) {
            addError(NORMALNOTE, e.getMessage());
        }

        if (errors.isEmpty())
            setResult("Successful registration.");
        else
            setResult("Failed to register");

        return review;
    }

    private void validateName(String name) throws Exception {
        if (name != null && name.length() < 4)
            throw new Exception("The name must contain at least 4 characters.");
        else
            throw new Exception("The field name is required");
    }

    private void validateNote(String number) throws Exception {
        String floatregex="^([+-]?\\d*\\.?\\d*)$";
        if (number != null) {
            if (!number.matches(floatregex))
                throw new Exception("Please enter a valid note.");
        }
        else
            throw new Exception("The field normal session note is required");
    }
}
