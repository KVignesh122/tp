package seedu.mtracker.commons.error;

public class InvalidNegativePriceError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NEGATIVE_PRICE_ERROR;
    }
}