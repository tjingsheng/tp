package seedu.address.model.localcourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Local Course's local description in SEPlendid.
 * Guarantees: immutable; is valid as declared in {@link #isValidLocalDescription(String)}
 */
public class LocalDescription {
    // Used in AppUtil#checkArgument and ParserUtil, JsonAdaptedXXX exceptions
    public static final String MESSAGE_CONSTRAINTS = "LocalDescription can take any values, given it starts with a "
        + "whitespace, and it should not be blank";

    /*
     * This matches a string that starts with a non-whitespace character.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    private final String value;

    /**
     * Constructs a {@code LocalDescription}.
     * localDescription is trimmed before checkArgument, as a standardization.
     *
     * @param localDescription A valid local description.
     */
    public LocalDescription(String localDescription) {
        localDescription = localDescription.trim();
        requireNonNull(localDescription);
        checkArgument(isValidLocalDescription(localDescription), MESSAGE_CONSTRAINTS);
        value = localDescription;
    }

    public static boolean isValidLocalDescription(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getValue() {
        return this.value;
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
        if (!(other instanceof LocalDescription)) {
            return false;
        }

        LocalDescription otherLocalDescription = (LocalDescription) other;
        // performs semantic check
        return value.equals(otherLocalDescription.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
