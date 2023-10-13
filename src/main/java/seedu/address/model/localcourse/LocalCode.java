package seedu.address.model.localcourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Local Course's local code in SEPlendid.
 * Guarantees: immutable; is valid as declared in {@link #isValidLocalCode(String)}
 */
public class LocalCode {

    // Used in AppUtil#checkArgument and ParserUtil, JsonAdaptedXXX exceptions
    public static final String MESSAGE_CONSTRAINTS = "LocalCode must start with an alphabet, and be no more than "
            + "10 alphanumeric characters";

    /*
     * This matches a string that starts with a non-whitespace character.
     */
    public static final String VALIDATION_REGEX = "[a-zA-Z][a-zA-Z0-9]{0,9}";

    public final String value;

    /**
     * Constructs an {@code LocalCode}.
     *
     * @param localcode A valid localcode.
     */
    public LocalCode(String localcode) {
        requireNonNull(localcode);
        checkArgument(isValidLocalCode(localcode), MESSAGE_CONSTRAINTS);
        value = localcode;
    }

    public static boolean isValidLocalCode(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LocalCode)) {
            return false;
        }

        LocalCode otherLocalCode = (LocalCode) other;
        // performs semantic check
        return value.equals(otherLocalCode.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
