package seedu.address.model.partnercourse;

/**
 * Represents the attribute which is related to partner course.
 */
public enum PartnerCourseAttribute {
    PARTNERCODE,
    PARTNERNAME,
    UNIVERSITY;

    public static final String MESSAGE_CONSTRAINTS =
            "There are only 3 attributes: partnercode, partnername and university.";

    /**
     * Returns true if the given attribute is valid.
     * @param test String to be tested
     * @return true if attribute is valid.
     */
    public static boolean isValidAttribute(String test) {
        switch(test) {
        case ("PARTNERCODE"):
        case ("PARTNERNAME"):
        case ("UNIVERSITY"):
            return true;
        default:
            return false;
        }
    }
}
