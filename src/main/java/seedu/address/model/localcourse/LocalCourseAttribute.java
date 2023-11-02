package seedu.address.model.localcourse;

/**
 * Represents the attribute which is related to local course.
 */
public enum LocalCourseAttribute {
    LOCALCODE,
    LOCALNAME,
    LOCALUNIT,
    LOCALDESCRIPTION;

    public static final String MESSAGE_CONSTRAINTS =
            "There are only 2 attributes: localcode and localname.";
    public static final String MESSAGE_CONSTRAINTS_UPDATE =
            "There are only 4 attributes for update: localcode, localname, localunit and localdescription.";
    public static final String MESSAGE_CONSTRAINTS_SEARCH =
            "There are only 3 attributes: localcode, localname and localdescription.";

    /**
     * Returns true if the given attribute is valid.
     * @param test String to be tested
     * @return True if attribute is valid.
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

    /**
     * Returns true if the given attribute is valid.
     * @param test String to be tested
     * @return true if attribute is valid.
     */
    public static boolean isValidAttributeForUpdate(String test) {
        switch (test) {
        case ("LOCALCODE"):
        case ("LOCALNAME"):
        case ("LOCALUNIT"):
        case ("LOCALDESCRIPTION"):
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
    public static boolean isValidAttributeForSearch(String test) {
        switch(test) {
        case ("LOCALCODE"):
        case ("LOCALNAME"):
        case ("LOCALDESCRIPTION"):
        default:
            return false;
        }
    }
}
