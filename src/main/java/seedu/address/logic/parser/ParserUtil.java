package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalDescription;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalUnit;
import seedu.address.model.mapping.MappingAttributeEnum;
import seedu.address.model.mapping.MappingMiscInformation;
import seedu.address.model.notes.Content;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerDescription;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.partnercourse.PartnerUnit;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.university.UniversityName;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String localCode} into an {@code LocalCode}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code localCode} is invalid.
     */
    public static LocalCode parseLocalCode(String localCode) throws ParseException {
        requireNonNull(localCode);
        String trimmedLocalCode = localCode.trim();
        if (!LocalCode.isValidLocalCode(trimmedLocalCode)) {
            throw new ParseException(LocalCode.MESSAGE_CONSTRAINTS);
        }
        return new LocalCode(localCode);
    }

    /**
     * Parses a {@code String localName} into an {@code LocalName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code localName} is invalid.
     */
    public static LocalName parseLocalName(String localName) throws ParseException {
        requireNonNull(localName);
        String trimmedLocalName = localName.trim();
        if (!LocalName.isValidLocalName(trimmedLocalName)) {
            throw new ParseException(LocalName.MESSAGE_CONSTRAINTS);
        }
        return new LocalName(localName);
    }

    /**
     * Parses a {@code String localUnit} into an {@code LocalUnit}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code localName} is invalid.
     */
    public static LocalUnit parseLocalUnit(String localUnit) throws ParseException {
        requireNonNull(localUnit);
        String trimmedLocalUnit = localUnit.trim();
        if (!LocalUnit.isValidLocalUnit(trimmedLocalUnit)) {
            throw new ParseException(LocalUnit.MESSAGE_CONSTRAINTS);
        }
        return new LocalUnit(localUnit);
    }

    /**
     * Parses a {@code String localDescription} into an {@code LocalDescription}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code localDescription} is invalid.
     */
    public static LocalDescription parseLocalDescription(String localDescription) throws ParseException {
        requireNonNull(localDescription);
        String trimmedLocalDescription = localDescription.trim();
        if (!LocalDescription.isValidLocalDescription(trimmedLocalDescription)) {
            throw new ParseException(LocalDescription.MESSAGE_CONSTRAINTS);
        }
        return new LocalDescription(localDescription);
    }

    /**
     * Parses a {@code String partnerCode} into an {@code PartnerCode}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code partnerCode} is invalid.
     */
    public static PartnerCode parsePartnerCode(String partnerCode) throws ParseException {
        requireNonNull(partnerCode);
        String trimmedPartnerCode = partnerCode.trim();
        if (!PartnerCode.isValidPartnerCode(trimmedPartnerCode)) {
            throw new ParseException(PartnerCode.MESSAGE_CONSTRAINTS);
        }
        return new PartnerCode(partnerCode);
    }

    /**
     * Parses a {@code String partnerName} into an {@code PartnerName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code partnerName} is invalid.
     */
    public static PartnerName parsePartnerName(String partnerName) throws ParseException {
        requireNonNull(partnerName);
        String trimmedPartnerName = partnerName.trim();
        if (!PartnerName.isValidPartnerName(trimmedPartnerName)) {
            throw new ParseException(PartnerName.MESSAGE_CONSTRAINTS);
        }
        return new PartnerName(partnerName);
    }

    /**
     * Parses a {@code String partnerUnit} into an {@code PartnerUnit}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code partnerUnit} is invalid.
     */
    public static PartnerUnit parsePartnerUnit(String partnerUnit) throws ParseException {
        requireNonNull(partnerUnit);
        String trimmedPartnerUnit = partnerUnit.trim();
        if (!PartnerUnit.isValidPartnerUnit(trimmedPartnerUnit)) {
            throw new ParseException(PartnerUnit.MESSAGE_CONSTRAINTS);
        }
        return new PartnerUnit(partnerUnit);
    }

    /**
     * Parses a {@code String partnerDescription} into an {@code PartnerDescription}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code partnerDescription} is invalid.
     */
    public static PartnerDescription parsePartnerDescription(String partnerDescription) throws ParseException {
        requireNonNull(partnerDescription);
        String trimmedPartnerDescription = partnerDescription.trim();
        if (!PartnerDescription.isValidPartnerDescription(trimmedPartnerDescription)) {
            throw new ParseException(PartnerDescription.MESSAGE_CONSTRAINTS);
        }
        return new PartnerDescription(partnerDescription);
    }

    /**
     * Parses a {@code String universityName}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static UniversityName parseUniversityName(String universityName) throws ParseException {
        requireNonNull(universityName);
        String trimmedUniversityName = universityName.trim();
        if (!UniversityName.isValidUniversityName(trimmedUniversityName)) {
            throw new ParseException(UniversityName.MESSAGE_CONSTRAINTS);
        }
        return new UniversityName(universityName);
    }

    /**
     * Parses a {@code String content}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Content parseContent(String content) throws ParseException {
        requireNonNull(content);
        String trimmedContent = content.trim();
        if (!Content.isValidContent(trimmedContent)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Content(trimmedContent);
    }

    /**
     * Parses a {@code String tags}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static String parseNoteTags(String tags) throws ParseException {
        requireNonNull(tags);
        String trimmedTags = tags.trim();
        return trimmedTags;
    }

    /**
     * Parse a {@code String mappingMiscInformation}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static MappingMiscInformation parseMappingMiscInformation(String mappingMiscInformation)
            throws ParseException {
        requireNonNull(mappingMiscInformation);
        String trimmedMappingMiscInformation = mappingMiscInformation.trim();
        if (!MappingMiscInformation.isValidMappingMiscInformation(trimmedMappingMiscInformation)) {
            throw new ParseException(MappingMiscInformation.MESSAGE_CONSTRAINTS);
        }
        return new MappingMiscInformation(trimmedMappingMiscInformation);
    }

    /**
     * Parse a {@code String MappingAttribute}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static MappingAttributeEnum parseMappingAttribute(String attributeInput)
            throws ParseException {
        requireNonNull(attributeInput);
        String trimmedAttributeInput = attributeInput.trim();

        if (!MappingAttributeEnum.isValidAttribute(trimmedAttributeInput)) {
            throw new ParseException(MappingAttributeEnum.MESSAGE_CONSTRAINTS);
        }

        Optional<MappingAttributeEnum> mappingAttributeOptional = MappingAttributeEnum.getAttributeEnumValue(
                trimmedAttributeInput);

        if (mappingAttributeOptional.isEmpty()) {
            // Defensive programming
            throw new ParseException(MappingAttributeEnum.MESSAGE_CONSTRAINTS);
        }
        return mappingAttributeOptional.get();
    }


    // SEPlendid ParserUtil starts here

    /**
     * Returns true if all arguments are enclosed in square brackets, and are non-empty.
     * The input string must be non-empty.
     *
     * @param args Arguments in the format of {@code [args1] [args2] ...}.
     * @return true if in correct format.
     */
    public static boolean areValuesEnclosedAndNonEmpty(String args) {
        if (args.isEmpty()) {
            return false;
        }
        // The number of unclosed open square brackets, used to validate input.
        int bracketCount = 0;
        StringBuilder currValue = new StringBuilder();

        for (int i = 0; i < args.length(); i++) {
            Character currChar = args.charAt(i);
            if (currChar.equals('[')) {
                currValue.setLength(0);
                bracketCount++;
            } else if (currChar.equals(']') && currValue.toString().trim().isEmpty()) {
                return false;
            } else if (currChar.equals(']')) {
                bracketCount--;
            } else {
                currValue.append(currChar);
            }

            if (bracketCount < 0 || bracketCount > 1) {
                return false;
            }
        }

        return bracketCount == 0;
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code SeplendidArgumentMap}.
     */
    public static boolean areArgumentsPresent(SeplendidArgumentMap argumentMap, SeplendidParameter... parameters) {
        return Stream.of(parameters).allMatch(parameter -> argumentMap.getValue(parameter).isPresent());
    }

    /**
     * Parses a {@code String attribute}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code attribute} is invalid.
     */
    public static LocalCourseAttribute parseLocalCourseAttribute(String attribute) throws ParseException {
        requireNonNull(attribute);
        String attributeLowerCase = attribute.toLowerCase();
        String resultAttribute = attributeLowerCase;
        switch (attributeLowerCase) {
        case ("localcode"):
            resultAttribute = "LOCALCODE";
            break;
        case ("localname"):
            resultAttribute = "LOCALNAME";
            break;
        case ("localdescription"):
            resultAttribute = "LOCALDESCRIPTION";
            break;
        default:
            break;
        }

        if (!LocalCourseAttribute.isValidAttributeForSearch(resultAttribute)) {
            throw new ParseException(LocalCourseAttribute.MESSAGE_CONSTRAINTS_SEARCH);
        }

        return LocalCourseAttribute.valueOf(resultAttribute);

    }

    /**
     * Parses a {@code String attribute}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code attribute} is invalid.
     */
    public static LocalCourseAttribute parseLocalCourseAttributeForSearch(String attribute) throws ParseException {
        requireNonNull(attribute);
        String attributeLowerCase = attribute.toLowerCase().trim();
        String resultAttribute = attributeLowerCase;

        switch (attributeLowerCase) {
        case ("localcode"):
            resultAttribute = "LOCALCODE";
            break;
        case ("localname"):
            resultAttribute = "LOCALNAME";
            break;
        case ("localdescription"):
            resultAttribute = "LOCALDESCRIPTION";
            break;
        default:
            break;
        }

        if (!LocalCourseAttribute.isValidAttributeForSearch(resultAttribute)) {
            throw new ParseException(LocalCourseAttribute.MESSAGE_CONSTRAINTS_SEARCH);
        }

        return LocalCourseAttribute.valueOf(resultAttribute);
    }

    /**
     * Parses a {@code String attribute}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code attribute} is invalid.
     */
    public static PartnerCourseAttribute parsePartnerCourseAttributeForSearch(String attribute) throws ParseException {
        requireNonNull(attribute);
        String attributeLowerCase = attribute.toLowerCase().trim();
        String resultAttribute = attributeLowerCase;

        switch (attributeLowerCase) {
        case ("partnercode"):
            resultAttribute = "PARTNERCODE";
            break;
        case ("partnername"):
            resultAttribute = "PARTNERNAME";
            break;
        default:
            break;
        }

        if (!PartnerCourseAttribute.isValidAttribute(resultAttribute)) {
            throw new ParseException(PartnerCourseAttribute.MESSAGE_CONSTRAINTS);
        }

        return PartnerCourseAttribute.valueOf(resultAttribute);
    }
}
