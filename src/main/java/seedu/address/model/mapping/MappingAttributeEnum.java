package seedu.address.model.mapping;

import java.util.Optional;

/**
 * Represents the attribute which is related to mapping.
 */
public enum MappingAttributeEnum {
    LOCALCODE,
    LOCALNAME,
    PARTNERCODE,
    PARTNERNAME,
    UNIVERSITY,
    INFORMATION;

    public static final String MESSAGE_CONSTRAINTS =
            "There are only 6 attributes: localcode, localname, partnercode, partnername,"
                    + " university and information.";

    /**
     * Returns true if the given attribute is valid.
     *
     * @param test String to be tested
     * @return true if attribute is valid.
     */
    public static boolean isValidAttribute(String test) {
        switch (test) {
        case ("localcode"):
        case ("localname"):
        case ("partnercode"):
        case ("partnername"):
        case ("university"):
        case ("information"):
            return true;
        default:
            return false;
        }
    }

    public static Optional<MappingAttributeEnum> getAttributeEnumValue(String input) {
        switch (input) {
        case ("localcode"):
            return Optional.of(LOCALCODE);
        case ("localname"):
            return Optional.of(LOCALNAME);
        case ("partnercode"):
            return Optional.of(PARTNERCODE);
        case ("partnername"):
            return Optional.of(PARTNERNAME);
        case ("university"):
            return Optional.of(UNIVERSITY);
        case ("information"):
            return Optional.of(INFORMATION);
        default:
            // This will not happen
            return Optional.empty();
        }
    }
}
