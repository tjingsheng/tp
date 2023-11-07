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
                         + "Must not be blank"),
    LOCALCOURSE_UNIT("LocalUnit:\n"
                   + "Must be blank\n"
                   + "Must be a non-negative numeric value\n"),
    LOCALCOURSE_DESCRIPTION("LocalDescription must:"
        + "Must not be blank"),
    LOCALCOURSE_ATTRIBUTE_SEARCH("There are only 3 attributes available for localCourse search:\n"
                                     + "localcode\n"
                                     + "localname\n"
                                     + "description\n"),
    LOCALCOURSE_ATTRIBUTE_SORT("There are only 2 attributes available for localCourse sort:\n"
                                   + "localcode\n"
                                   + "localname\n"),
    LOCALCOURSE_ATTRIBUTE_UPDATE("There are only 4 attributes available for localCourse update:\n"
                                     + "localcode\n"
                                     + "localname\n"
                                     + "unit\n"
                                     + "description\n"),
    PARTNERCOURSE_CODE("PartnerCode:\n"
                         + "Must not be blank\n"
                         + "Must only contain alphanumeric characters\n"
                         + "Be no more than 10 characters long\n"),
    PARTNERCOURSE_NAME("PartnerName:\n"
                         + "Must not be blank"),
    PARTNERCOURSE_UNIT("PartnerUnit:\n"
                         + "Must be blank\n"
                         + "Must be a non-negative numeric value\n"),
    PARTNERCOURSE_DESCRIPTION("PartnerDescription must:"
                                + "Must not be blank"),
    PARTNERCOURSE_ATTRIBUTE_SEARCH("There are only 4 attributes available for partnercourse search:\n"
                                     + "partnercode\n"
                                     + "partnername\n"
                                     + "description\n"
                                     + "university"),
    PARTNERCOURSE_ATTRIBUTE_SORT("There are only 3 attributes available for partnercourse sort:\n"
                                   + "partnercode\n"
                                   + "partnername\n"
                                   + "university"),
    PARTNERCOURSE_ATTRIBUTE_UPDATE("There are only 4 attributes available for partnercourse update:\n"
                                     + "partnercode\n"
                                     + "partnername\n"
                                     + "unit\n"
                                     + "description\n"),
    MAPPING_ATTRIBUTE_SEARCH("There are only 6 available for mapping search:\n"
                                 + "localcode\n"
                                 + "localname\n"
                                 + "partnercode\n"
                                 + "partnername\n"
                                 + "university\n"
                                 + "information\n"),
    MAPPING_ATTRIBUTE_SORT("There are only 6 available for mapping sort:\n"
                                 + "localcode\n"
                                 + "localname\n"
                                 + "partnercode\n"
                                 + "partnername\n"
                                 + "university\n"
                                 + "information\n");

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
