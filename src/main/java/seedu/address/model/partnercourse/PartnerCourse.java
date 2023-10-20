package seedu.address.model.partnercourse;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.university.University;

/**
 * Represents a Partner Course in SEPlendid.
 * Guarantees: details are present and not null, field values are validated and immutable.
 */
public class PartnerCourse {
    private final University partnerUniversity;
    private final PartnerCode partnerCode;
    private final PartnerName partnerName;

    /**
     * Every field must be present and not null
     */
    public PartnerCourse(University pu, PartnerCode pc, PartnerName pn) {
        requireAllNonNull(pu, pc, pn);
        partnerUniversity = pu;
        partnerCode = pc;
        partnerName = pn;
    }
    public University getPartnerUniversity() {
        return partnerUniversity;
    }

    public PartnerCode getPartnerCode() {
        return partnerCode;
    }

    public PartnerName getPartnerName() {
        return partnerName;
    }

    /**
     * Returns true if both PartnerCourses have the same partnerCode.
     * Assumption: partnerCode is the primary key i.e. there exists
     * no two distinct PartnerCourses with the same partnerCode.
     *
     * @param otherPartnerCourse This is the other partner course.
     */
    public boolean isSamePartnerCourse(PartnerCourse otherPartnerCourse) {
        if (otherPartnerCourse == this) {
            return true;
        }

        if (otherPartnerCourse == null) {
            return false;
        }

        return otherPartnerCourse.getPartnerCode().equals(getPartnerCode());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourse)) {
            return false;
        }

        PartnerCourse otherPartnerCourse = (PartnerCourse) other;
        return partnerUniversity.equals(otherPartnerCourse.partnerUniversity)
                && partnerCode.equals(otherPartnerCourse.partnerCode)
                && partnerName.equals(otherPartnerCourse.partnerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerUniversity, partnerCode, partnerName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerUniversity", partnerUniversity)
                .add("partnerCode", partnerCode)
                .add("partnerName", partnerName)
                .toString();
    }
}
