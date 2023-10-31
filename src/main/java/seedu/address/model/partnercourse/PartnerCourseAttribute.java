package seedu.address.model.partnercourse;

/**
 * Represents the attribute which is related to partner course.
 */
public enum PartnerCourseAttribute {
    UNIVERSITY,
    PARTNERCODE,
    PARTNERNAME,
    UNIT,
    DESCRIPTION;

    public static final String MESSAGE_CONSTRAINTS_SORT =
            "There are only 3 attributes: partnercode, partnername and university.";

    public static final String MESSAGE_CONSTRAINTS_EDIT =
            "There are only 3 attributes: partnercode, partnername, university and description.";

    /**
     * Returns true if the given attribute is valid for sort command.
     * @param test String to be tested
     * @return true if attribute is valid.
     */
    public static boolean isValidAttributeForSort(String test) {
        switch(test) {
        case ("UNIVERSITY"):
        case ("PARTNERCODE"):
        case ("PARTNERNAME"):
            return true;
        default:
            return false;
        }
    }

    /**
     * Returns true if the given attribute is valid.
     * @param test String to be tested
     * @return true if attribute is valid.
     */
    public static boolean isValidAttributeForEdit(String test) {
        switch(test) {
        case ("UNIVERSITY"):
        case ("PARTNERCODE"):
        case ("PARTNERNAME"):
        case ("UNIT"):
        case ("DESCRIPTION"):
            return true;
        default:
            return false;
        }
    }
}
