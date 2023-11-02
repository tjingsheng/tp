package seedu.address.model.university;

/**
 * Represents the attribute which is related to university.
 */
public enum UniversityAttribute {
    UNIVERSITYNAME,
    COUNTRY;

    public static final String MESSAGE_CONSTRAINTS =
            "There are only 2 attributes: universityname, country";

    /**
     * Returns trye if the given attribute is valid.
     * @param test String to be tested.
     * @return True if attribute is valid.
     */
    public static boolean isValidAttribute(String test) {
        switch(test) {
        case ("UNIVERSITYNAME"):
            return true;
        default:
            return false;
        }
    }
}
