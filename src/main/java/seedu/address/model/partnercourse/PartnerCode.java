package seedu.address.model.partnercourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
public class PartnerCode {
    public static final String MESSAGE_CONSTRAINTS = "PartnerCode must start with an alphabet, and be no mor than "
        + "10 alphanumeric characters";

    public static final String VALIDATION_REGEX = "[a-zA-Z][a-zA-Z0-9]{0,9}";

    public final String value;

    public PartnerCode(String partnerCode) {
        requireNonNull(partnerCode);
        checkArgument(isValidPartnerCode(partnerCode), MESSAGE_CONSTRAINTS);
        value = partnerCode;
    }

    public static boolean isValidPartnerCode(String test) {
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

        if (!(other instanceof PartnerCode)) {
            return false;
        }

        PartnerCode otherPartnerCode = (PartnerCode) other;
        return value.equals(otherPartnerCode.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
