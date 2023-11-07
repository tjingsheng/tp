package seedu.address.model;

/**
 * Enum for model constraint messages.
 */
public enum ConstraintMessage {
    LOCALCOURSE_CODE("LocalCode:\n"
            + "Must not be blank\n"
            + "Must only contain alphanumeric characters\n"
            + "Be no more than 10 characters long\n"),
    LOCALCOURSE_NAME("LocalName:\n"
            + "Must be non-empty, and must be between 1-76 characters long."),
    LOCALCOURSE_UNIT("LocalUnit:\n"
            + "Must not be blank\n"
            + "Must be a non-negative numeric value\n"),
    LOCALCOURSE_DESCRIPTION("LocalDescription must:"
            + "Must not be blank"),
    LOCALCOURSE_ATTRIBUTE_SEARCH("There are only 3 attributes available for localcourse search:\n"
            + "localcode\n"
            + "localname\n"
            + "localdescription\n"),
    LOCALCOURSE_ATTRIBUTE_SORT("There are only 2 attributes available for localcourse sort:\n"
            + "localcode\n"
            + "localname\n"),
    LOCALCOURSE_ATTRIBUTE_UPDATE("There are only 4 attributes available for localcourse update:\n"
            + "localcode\n"
            + "localname\n"
            + "localunit\n"
            + "localdescription\n");

    private final String value;

    /**
     * Constructs a ConstraintMessage with the specified value.
     *
     * @param description The usage message value.
     */
    ConstraintMessage(String description) {
        this.value = description;
    }

    /**
     * Gets the value of the constraint message.
     *
     * @return The usage message value.
     */
    public String getValue() {
        return value;
    }
}
