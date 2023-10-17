package seedu.address.model.partnercourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
public class PartnerName {

    public static final String MESSAGE_CONSTRAINTS = "PartnerName can take any values, and it should not be blank";

    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    public PartnerName(String partnerName) {
        requireNonNull(partnerName);
        checkArgument(isValidPartnerName(partnerName), MESSAGE_CONSTRAINTS);
        value = partnerName;
    }

    public static boolean isValidPartnerName(String test) {
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

        if (!(other instanceof PartnerName)) {
            return false;
        }

        PartnerName otherPartnerName = (PartnerName) other;

        return value.equals(otherPartnerName.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
