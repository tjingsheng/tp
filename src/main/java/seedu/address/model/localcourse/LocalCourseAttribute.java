package seedu.address.model.localcourse;

/**
 * Represents the attribute which is related to local course.
 */
public enum LocalCourseAttribute {
    LOCALCODE,
    LOCALNAME;

    public static final String MESSAGE_CONSTRAINTS =
            "There are only 2 attributes: localcode and localname.";

    /**
     * Returns true if the given attribute is valid.
     * @param test String to be tested
     * @return true if attribute is valid.
     */
    public static boolean isValidAttribute(String test) {
        switch(test) {
        case ("LOCALCODE"):
        case ("LOCALNAME"):
            return true;
        default:
            return false;
        }
    }
}
