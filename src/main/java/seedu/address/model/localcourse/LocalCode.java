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
     * This matches alphanumeric string of length 1-10, starting with an alphabet.
     */
    public static final String VALIDATION_REGEX = "[a-zA-Z][a-zA-Z0-9]{0,9}";

    // TBD: refactor codebase to allow this to be set to private
    public final String value;

    /**
     * Constructs an {@code LocalCode}.
     *
     * @param localCode A valid localCode.
     */
    public LocalCode(String localCode) {
        requireNonNull(localCode);
        checkArgument(isValidLocalCode(localCode), MESSAGE_CONSTRAINTS);
        value = localCode;
    }

    public static boolean isValidLocalCode(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getValue() {
        return this.value;
    }

    // Note: be careful not to modify this, as it is used in auto-invocation of toString
    // in places where string is expected
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
