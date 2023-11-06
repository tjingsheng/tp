package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_OBJECT;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_ATTRIBUTE;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_ATTRIBUTE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_ATTRIBUTE_UPDATE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.INVALID_UNIVERSITY_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_UNIVERSITY_NAME;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.university.UniversityName;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "123456";
    private static final String VALID_ADDRESS = "123 Main Street #0505";
    private static final String VALID_EMAIL = "rachel@example.com";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
                -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_OBJECT, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_OBJECT, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(nameWithWhitespace));
    }

    @Test
    public void parsePhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePhone((String) null));
    }

    @Test
    public void parsePhone_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithoutWhitespace_returnsPhone() throws Exception {
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(VALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithWhitespace_returnsTrimmedPhone() throws Exception {
        String phoneWithWhitespace = WHITESPACE + VALID_PHONE + WHITESPACE;
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(phoneWithWhitespace));
    }

    @Test
    public void parseAddress_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseAddress((String) null));
    }

    @Test
    public void parseAddress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAddress(INVALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithoutWhitespace_returnsAddress() throws Exception {
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, ParserUtil.parseAddress(VALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithWhitespace_returnsTrimmedAddress() throws Exception {
        String addressWithWhitespace = WHITESPACE + VALID_ADDRESS + WHITESPACE;
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, ParserUtil.parseAddress(addressWithWhitespace));
    }

    @Test
    public void parseEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseEmail((String) null));
    }

    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmail(INVALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithoutWhitespace_returnsEmail() throws Exception {
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(VALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedEmail() throws Exception {
        String emailWithWhitespace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(emailWithWhitespace));
    }

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }

    //localcourse

    @Test
    public void parseLocalCode_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseLocalCode((String) null));
    }

    @Test
    public void parseLocalCode_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseLocalCode(INVALID_LOCAL_COURSE_CODE));
    }

    @Test
    public void parseLocalCode_validValueWithoutWhitespace_returnsLocalCode() throws Exception {
        LocalCode expectedLocalCode = new LocalCode(TYPICAL_LOCAL_COURSE_CODE);
        assertEquals(expectedLocalCode, ParserUtil.parseLocalCode(TYPICAL_LOCAL_COURSE_CODE));
    }

    @Test
    public void parseLocalCode_validValueWithWhitespace_returnsTrimmedLocalCode() throws Exception {
        String localCodeWithWhitespace = WHITESPACE + TYPICAL_LOCAL_COURSE_CODE + WHITESPACE;
        LocalCode expectedLocalCode = new LocalCode(TYPICAL_LOCAL_COURSE_CODE);
        assertEquals(expectedLocalCode, ParserUtil.parseLocalCode(localCodeWithWhitespace));
    }

    @Test
    public void parseLocalName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseLocalName((String) null));
    }

    @Test
    public void parseLocalName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseLocalName(INVALID_LOCAL_COURSE_NAME));
    }

    @Test
    public void parseLocalName_validValueWithoutWhitespace_returnsLocalName() throws Exception {
        LocalName expectedLocalName = new LocalName(TYPICAL_LOCAL_COURSE_NAME);
        assertEquals(expectedLocalName, ParserUtil.parseLocalName(TYPICAL_LOCAL_COURSE_NAME));
    }

    @Test
    public void parseLocalName_validValueWithWhitespace_returnsTrimmedLocalName() throws Exception {
        String localNameWithWhitespace = WHITESPACE + TYPICAL_LOCAL_COURSE_NAME + WHITESPACE;
        LocalName expectedLocalName = new LocalName(TYPICAL_LOCAL_COURSE_NAME);
        assertEquals(expectedLocalName, ParserUtil.parseLocalName(localNameWithWhitespace));
    }

    //partner course

    @Test
    public void parseUniversityName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseUniversityName((String) null));
    }

    @Test
    public void parseUniversityName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseUniversityName(INVALID_UNIVERSITY_NAME));
    }

    @Test
    public void parseUniversityName_validValueWithoutWhitespace_returnsUniversityName() throws Exception {
        UniversityName expectedUniversityName = new UniversityName(TYPICAL_UNIVERSITY_NAME);
        assertEquals(expectedUniversityName, ParserUtil.parseUniversityName(TYPICAL_UNIVERSITY_NAME));
    }

    @Test
    public void parseUniversityName_validValueWithWhitespace_returnsTrimmedUniversityName() throws Exception {
        String universityNameWithWhitespace = WHITESPACE + TYPICAL_UNIVERSITY_NAME + WHITESPACE;
        UniversityName expectedUniversityName = new UniversityName(TYPICAL_UNIVERSITY_NAME);
        assertEquals(expectedUniversityName, ParserUtil.parseUniversityName(universityNameWithWhitespace));
    }

    @Test
    public void parsePartnerCode_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePartnerCode((String) null));
    }

    @Test
    public void parsePartnerCode_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePartnerCode(INVALID_PARTNER_COURSE_CODE));
    }

    @Test
    public void parsePartnerCode_validValueWithoutWhitespace_returnsPartnerCode() throws Exception {
        PartnerCode expectedPartnerCode = new PartnerCode(TYPICAL_PARTNER_COURSE_CODE);
        assertEquals(expectedPartnerCode, ParserUtil.parsePartnerCode(TYPICAL_PARTNER_COURSE_CODE));
    }

    @Test
    public void parsePartnerCode_validValueWithWhitespace_returnsTrimmedPartnerCode() throws Exception {
        String partnerCodeWithWhitespace = WHITESPACE + TYPICAL_PARTNER_COURSE_CODE + WHITESPACE;
        PartnerCode expectedPartnerCode = new PartnerCode(TYPICAL_PARTNER_COURSE_CODE);
        assertEquals(expectedPartnerCode, ParserUtil.parsePartnerCode(partnerCodeWithWhitespace));
    }

    @Test
    public void parsePartnerName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePartnerName((String) null));
    }

    @Test
    public void parsePartnerName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePartnerName(INVALID_PARTNER_COURSE_NAME));
    }

    @Test
    public void parsePartnerName_validValueWithoutWhitespace_returnsPartnerName() throws Exception {
        PartnerName expectedPartnerName = new PartnerName(TYPICAL_PARTNER_COURSE_NAME);
        assertEquals(expectedPartnerName, ParserUtil.parsePartnerName(TYPICAL_PARTNER_COURSE_NAME));
    }

    @Test
    public void parsePartnerName_validValueWithWhitespace_returnsTrimmedPartnerName() throws Exception {
        String partnerNameWithWhitespace = WHITESPACE + TYPICAL_PARTNER_COURSE_NAME + WHITESPACE;
        PartnerName expectedPartnerName = new PartnerName(TYPICAL_PARTNER_COURSE_NAME);
        assertEquals(expectedPartnerName, ParserUtil.parsePartnerName(partnerNameWithWhitespace));
    }

    @Test
    public void areValuesEnclosedAndNonEmpty_emptyArgs_returnsFalse() throws Exception {
        assertFalse(areValuesEnclosedAndNonEmpty(""));
    }

    @Test
    public void areValuesEnclosedAndNonEmpty_invalidValueWithMismatchBrackets1_returnsFalse() throws Exception {
        assertFalse(areValuesEnclosedAndNonEmpty("[CS2103T [Software Engineering]"));
    }

    @Test
    public void areValuesEnclosedAndNonEmpty_validValue1_returnsTrue() throws Exception {
        assertTrue(areValuesEnclosedAndNonEmpty("[CS2103T] [Software Engineering]"));
    }

    @Test
    public void areValuesEnclosedAndNonEmpty_invalidValueWithMismatchBrackets2_returnsFalse() throws Exception {
        assertFalse(areValuesEnclosedAndNonEmpty("[CS2103T] [Software Engineering [potato tomato]"));
    }

    @Test
    public void areValuesEnclosedAndNonEmpty_validValue2_returnsTrue() throws Exception {
        assertTrue(areValuesEnclosedAndNonEmpty("[CS2103T] [Software Engineering] [potato tomato]"));
    }

    // This shouldn't happen though, due to initial trim in SeplendidParser.
    @Test
    public void areValuesEnclosedAndNonEmpty_precedingWhiteSpaceValue_returnsTrue() throws Exception {
        assertTrue(areValuesEnclosedAndNonEmpty("      [CS2103T] [Software Engineering]"));
    }

    // This shouldn't happen though, due to initial trim in SeplendidParser.
    @Test
    public void areValuesEnclosedAndNonEmpty_trailingWhiteSpaceValue_returnsTrue() throws Exception {
        assertTrue(areValuesEnclosedAndNonEmpty("[CS2103T] [Software Engineering]       "));
    }

    @Test
    public void parseLocalCourseAttributeForSearch_validValue() throws ParseException {
        assertEquals(LocalCourseAttribute.LOCALNAME, ParserUtil.parseLocalCourseAttributeForSearch("localname"));
    }

    @Test
    public void parseLocalCourseAttributeForSearch_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseLocalCourseAttributeForSearch("local unit"));
    }

    @Test
    public void parseLocalCourseAttributeForSort_null_throwsNullPointerException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseLocalCourseAttributeForSort((String) null));
    }

    @Test
    public void parseLocalCourseAttributeForSort_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () ->
            ParserUtil.parseLocalCourseAttributeForSort(INVALID_LOCAL_COURSE_ATTRIBUTE));
    }

    @Test
    public void parseLocalCourseAttributeForUpdate_validValue() throws ParseException {
        assertEquals(LocalCourseAttribute.LOCALNAME, ParserUtil.parseLocalCourseAttributeForSearch("localname"));
    }

    @Test
    public void parseLocalCourseAttributeForUpdate_validValueWithWhitespace_throwsParseException() {
        String localCourseAttributeWithWhitespace = WHITESPACE + "localname" + WHITESPACE;
        assertThrows(ParseException.class, (
            ) -> ParserUtil.parseLocalCourseAttributeForUpdate(localCourseAttributeWithWhitespace));
    }

    @Test
    public void parsePartnerCourseAttributeForSort_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePartnerCourseAttributeForSort((String) null));
    }

    @Test
    public void parsePartnerCourseAttributeForSort_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () ->
                ParserUtil.parsePartnerCourseAttributeForSort(INVALID_PARTNER_COURSE_ATTRIBUTE));
    }

    @Test
    public void parsePartnerCourseAttributeForSort_validValueWithoutWhitespaceAndAllCaps_returnsPartnerCourseAttribute()
            throws Exception {
        PartnerCourseAttribute expectedPartnerCourseAttribute = PartnerCourseAttribute.PARTNERCODE;
        assertEquals(expectedPartnerCourseAttribute, ParserUtil.parsePartnerCourseAttributeForSort("partnErcoDe"));
    }

    @Test
    public void parsePartnerCourseAttributeForSort_validValueWithWhitespace_returnsTrimmedPartnerCourseAttribute()
            throws Exception {
        String partnerCourseAttributeWithWhitespace = WHITESPACE + "PartnerName" + WHITESPACE;
        PartnerCourseAttribute expectedPartnerCourseAttribute = PartnerCourseAttribute.PARTNERNAME;
        assertEquals(expectedPartnerCourseAttribute,
                ParserUtil.parsePartnerCourseAttributeForSort(partnerCourseAttributeWithWhitespace));
    }

    @Test
    public void parsePartnerCourseAttributeForUpdate_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePartnerCourseAttributeForUpdate((String) null));
    }

    @Test
    public void parsePartnerCourseAttributeForUpdate_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () ->
                ParserUtil.parsePartnerCourseAttributeForUpdate(INVALID_PARTNER_COURSE_ATTRIBUTE_UPDATE));
    }

    @Test
    public void parsePartnerCourseAttributeForUpdate_validValueWithoutAllCaps_returnsPartnerCourseAttribute()
            throws Exception {
        PartnerCourseAttribute expectedPartnerCourseAttribute = PartnerCourseAttribute.PARTNERCODE;
        assertEquals(expectedPartnerCourseAttribute, ParserUtil.parsePartnerCourseAttributeForUpdate("partnErcoDe"));
    }

    @Test
    public void parsePartnerCourseAttributeForUpdate_validValueWithWhitespace_returnsTrimmedPartnerCourseAttribute()
            throws Exception {
        String partnerCourseAttributeWithWhitespace = WHITESPACE + "PartnerName" + WHITESPACE;
        PartnerCourseAttribute expectedPartnerCourseAttribute = PartnerCourseAttribute.PARTNERNAME;
        assertEquals(expectedPartnerCourseAttribute,
                ParserUtil.parsePartnerCourseAttributeForUpdate(partnerCourseAttributeWithWhitespace));
    }

    @Test
    public void parsePartnerCourseAttributeForSearch_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePartnerCourseAttributeForSearch((String) null));
    }

    @Test
    public void parsePartnerCourseAttributeForSearch_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () ->
                ParserUtil.parsePartnerCourseAttributeForSearch(INVALID_PARTNER_COURSE_ATTRIBUTE));
    }

    @Test
    public void
        parsePartnerCourseAttributeForSearch_validValueWithoutWhitespaceAndAllCaps_returnsPartnerCourseAttribute()
            throws Exception {
        PartnerCourseAttribute expectedPartnerCourseAttribute = PartnerCourseAttribute.PARTNERCODE;
        assertEquals(expectedPartnerCourseAttribute, ParserUtil.parsePartnerCourseAttributeForSearch("partnErcoDe"));
    }

    @Test
    public void parsePartnerCourseAttributeForSearch_validValueWithWhitespace_returnsTrimmedPartnerCourseAttribute()
            throws Exception {
        String partnerCourseAttributeWithWhitespace = WHITESPACE + "PartnerName" + WHITESPACE;
        PartnerCourseAttribute expectedPartnerCourseAttribute = PartnerCourseAttribute.PARTNERNAME;
        assertEquals(expectedPartnerCourseAttribute,
                ParserUtil.parsePartnerCourseAttributeForSearch(partnerCourseAttributeWithWhitespace));
    }
}
