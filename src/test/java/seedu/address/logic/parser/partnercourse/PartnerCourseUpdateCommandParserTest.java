package seedu.address.logic.parser.partnercourse;


import static seedu.address.logic.commands.CommandTestUtil.UNNECESSARY_WHITESPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TestUtil.getSquareBracketWrappedArgument;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_ATTRIBUTE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_UNIT;
import static seedu.address.testutil.TypicalObjects.INVALID_UNIVERSITY_NAME;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.UsageMessage;
import seedu.address.logic.commands.partnercourse.PartnerCourseCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseUpdateCommand;
import seedu.address.model.ConstraintMessage;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerUnit;

public class PartnerCourseUpdateCommandParserTest {

    private static final String commandActionWord = PartnerCourseCommand.COMMAND_WORD
            + PartnerCourseUpdateCommand.ACTION_WORD;

    private PartnerCourseUpdateCommandParser parser = new PartnerCourseUpdateCommandParser();

    @Test
    public void parse_unnecessaryWhiteSpace_success() {


        // add unnecessary whitespace
        assertParseSuccess(parser,
                UNNECESSARY_WHITESPACE
                        + PartnerCourseCommand.COMMAND_WORD
                        + UNNECESSARY_WHITESPACE
                        + PartnerCourseUpdateCommand.ACTION_WORD
                        + UNNECESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + UNNECESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + UNNECESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString())
                        + UNNECESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument("10.0"),
                new PartnerCourseUpdateCommand(
                        COMP1000.getPartnerUniversity().getUniversityName(),
                        COMP1000.getPartnerCode(),
                        PartnerCourseAttribute.UNIT,
                        "10.0"));
    }

    @Test
    public void parse_argumentNotClosedOrEmpty_failure() {
        // empty argument
        assertParseFailure(parser, commandActionWord
                + getSquareBracketWrappedArgument(""), UsageMessage.PARTNERCOURSE_UPDATE.getValueWithEmptyArgs());
    }

    @Test
    public void parse_argumentMissing_failure() {
        String expectedMessage = UsageMessage.PARTNERCOURSE_UPDATE.getValue();

        // missing universityName argument
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString())
                        + getSquareBracketWrappedArgument("10.0"),
                expectedMessage);

        // missing partnerCode argument
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString())
                        + getSquareBracketWrappedArgument("10.0"),
                expectedMessage);

        // missing attribute argument
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument("10.0"),
                expectedMessage);

        // missing updateValue argument
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString()),
                expectedMessage);

        // all arguments missing
        assertParseFailure(parser, commandActionWord, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // For universityName, partnerName, and partnerDescription
        // Arguments are trimmed before checkArgument, as a standardisation
        // Therefore an argument starting with a whitespace will pass,
        // while a whitespace alone will not. A whitespace alone will trigger
        // ParseException due to ParserUtil#areValuesEncloseAndNonEmpty.

        // invalid universityName
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(INVALID_UNIVERSITY_NAME)
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString())
                        + getSquareBracketWrappedArgument("10.0"),
                UsageMessage.PARTNERCOURSE_UPDATE.getValueWithEmptyArgs());

        // invalid partnerCode
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_CODE)
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString())
                        + getSquareBracketWrappedArgument("10.0"),
                PartnerCode.MESSAGE_CONSTRAINTS);

        // invalid partnerAttribute
        assertParseFailure(
            parser,
            commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_ATTRIBUTE)
                        + getSquareBracketWrappedArgument("10.0"),
            ConstraintMessage.PARTNERCOURSE_ATTRIBUTE_UPDATE.getValue());

        // invalid updatedValue for partnerCode
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.CODE.toString())
                        + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_CODE),
                PartnerCode.MESSAGE_CONSTRAINTS);

        // invalid updatedValue for unit
        assertParseFailure(
                parser,
                commandActionWord
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerUniversity().toString())
                        + getSquareBracketWrappedArgument(COMP1000.getPartnerCode().toString())
                        + getSquareBracketWrappedArgument(PartnerCourseAttribute.UNIT.toString())
                        + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_UNIT.toString()),
                PartnerUnit.MESSAGE_CONSTRAINTS);
    }
}
