package seedu.address.model.partnercourse;

/**
 * Represents the attribute related to a partner course.
 */
public enum PartnerCourseAttribute {
    CODE("partnercode"),
    NAME("partnername"),
    UNIT("units"),
    DESCRIPTION("description"),
    UNIVERSITY("university");

    private final String value;

    /**
     * Constructor for PartnerCourseAttribute.
     *
     * @param value The string representation of the attribute.
     */
    PartnerCourseAttribute(String value) {
        this.value = value;
    }

    /**
     * Gets the string representation of the attribute.
     *
     * @return The string representation of the attribute.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Converts a string to the corresponding PartnerCourseAttribute.
     *
     * @param text The string to be converted.
     * @return The PartnerCourseAttribute corresponding to the input string, or null if not found.
     */
    public static PartnerCourseAttribute fromString(String text) {
        if (text == null) {
            return null;
        }
        for (PartnerCourseAttribute enumValue : PartnerCourseAttribute.values()) {
            if (enumValue.value.equals(text)) {
                return enumValue;
            }
        }
        return null;
    }

    /**
     * Checks if the given attribute is valid for sorting.
     *
     * @param test The string to be tested.
     * @return True if the attribute is valid for sorting, false otherwise.
     */
    public static boolean isValidAttributeForSort(String test) {
        PartnerCourseAttribute attribute = PartnerCourseAttribute.fromString(test);
        if (attribute == null) {
            return false;
        }

        switch (attribute) {
        case CODE:
        case NAME:
        case UNIVERSITY:
            return true;
        default:
            return false;
        }
    }

    /**
     * Checks if the given attribute is valid for updating.
     *
     * @param test The string to be tested.
     * @return True if the attribute is valid for updating, false otherwise.
     */
    public static boolean isValidAttributeForUpdate(String test) {
        PartnerCourseAttribute attribute = PartnerCourseAttribute.fromString(test);
        if (attribute == null) {
            return false;
        }

        switch (attribute) {
        case CODE:
        case NAME:
        case UNIT:
        case DESCRIPTION:
            return true;
        default:
            return false;
        }
    }

    /**
     * Checks if the given attribute is valid for searching.
     *
     * @param test The string to be tested.
     * @return True if the attribute is valid for searching, false otherwise.
     */
    public static boolean isValidAttributeForSearch(String test) {
        PartnerCourseAttribute attribute = PartnerCourseAttribute.fromString(test);
        if (attribute == null) {
            return false;
        }

        switch (attribute) {
        case CODE:
        case NAME:
        case DESCRIPTION:
        case UNIVERSITY:
            return true;
        default:
            return false;
        }
    }
}
