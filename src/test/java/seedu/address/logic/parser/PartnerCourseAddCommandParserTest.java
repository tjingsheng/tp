package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.UNNCESSARY_WHITESPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TestUtil.getSquareBracketWrappedArgument;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE_DESCRIPTION;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE_UNIT;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_UNIVERSITY_NAME;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_DESCRIPTION;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE_UNIT;
import static seedu.address.testutil.TypicalObjects.TYPICAL_UNIVERSITY_NAME;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.commands.PartnerCourseCommand;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.testutil.PartnerCourseBuilder;
import seedu.address.testutil.PartnerCourseUtil;
import seedu.address.testutil.TypicalObjects;

public class PartnerCourseAddCommandParserTest {
    private static final String commandActionWord =
        PartnerCourseCommand.COMMAND_WORD + " " + PartnerCourseAddCommand.ACTION_WORD + " ";

    private PartnerCourseAddCommandParser parser = new PartnerCourseAddCommandParser();

    @Test
    public void parse_unnecessaryWhiteSpace_success() {
        PartnerCourse expectedPartnerCourse = new PartnerCourseBuilder(TypicalObjects.COMP1000).build();

        // add unnecessary whitespace
        assertParseSuccess(parser,
            UNNCESSARY_WHITESPACE
                + PartnerCourseCommand.COMMAND_WORD
                + UNNCESSARY_WHITESPACE
                + PartnerCourseAddCommand.ACTION_WORD
                + UNNCESSARY_WHITESPACE
                + getSquareBracketWrappedArgument(expectedPartnerCourse.getPartnerUniversity()
                                                                       .getUniversityName()
                                                                       .toString())
                + UNNCESSARY_WHITESPACE
                + getSquareBracketWrappedArgument(expectedPartnerCourse.getPartnerCode().toString())
                + UNNCESSARY_WHITESPACE
                + getSquareBracketWrappedArgument(expectedPartnerCourse.getPartnerName().toString())
                + UNNCESSARY_WHITESPACE
                + getSquareBracketWrappedArgument(expectedPartnerCourse.getPartnerUnit().toString())
                + UNNCESSARY_WHITESPACE
                + getSquareBracketWrappedArgument(expectedPartnerCourse.getPartnerDescription().toString()),
            new PartnerCourseAddCommand(expectedPartnerCourse));
    }

    @Test
    void parse_argumentNotClosedOrEmpty_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE);

        // missing open bracket
        assertParseFailure(
            parser,
            commandActionWord + PartnerCourseUtil.getPartnerCourseArgumentsForAddCommand(TypicalObjects.COMP1000)
                                                 .substring(1),
            expectedMessage);

        // empty argument
        assertParseFailure(
            parser,
            commandActionWord
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_CODE)
                + " "
                + getSquareBracketWrappedArgument(""),
            expectedMessage);
    }


    @Test
    public void parse_allArgumentMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE);

        // missing patrtnercode argument
        assertParseFailure(parser,
            commandActionWord + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_NAME),
            expectedMessage);

        // missing partnername argument
        assertParseFailure(parser,
            commandActionWord + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_CODE),
            expectedMessage);

        // all arguments missing
        assertParseFailure(parser, commandActionWord, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid partnerCode
        assertParseFailure(parser,
            commandActionWord
                + getSquareBracketWrappedArgument(TYPICAL_UNIVERSITY_NAME)
                + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_CODE)
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_NAME)
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_UNIT.toString())
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_DESCRIPTION),
            PartnerCode.MESSAGE_CONSTRAINTS);

        // invalid partnerName
        // This test also ensures that the input to checkArgument and parsePartnerName matches.
        // partnerName is trimmed before checkArgument, as a standardisation
        // Therefore a partnerName argument starting with a whitespace will pass,
        // while a whitespace alone will not. A whitespace alone will trigger
        // ParseException due to ParserUtil#areValuesEncloseAndNonEmpty.
        assertParseFailure(parser,
            commandActionWord
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_CODE)
                + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_NAME)
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_UNIT.toString())
                + getSquareBracketWrappedArgument(TYPICAL_PARTNER_COURSE_DESCRIPTION),
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE));
    }

    @Test
    public void parse_edgeCasePartnerNameValue_success() {
        assertParseSuccess(parser,
            commandActionWord
                + getSquareBracketWrappedArgument(EDGE_CASE_VALID_UNIVERSITY_NAME)
                + getSquareBracketWrappedArgument(EDGE_CASE_VALID_PARTNER_COURSE_CODE)
                + getSquareBracketWrappedArgument(EDGE_CASE_VALID_PARTNER_COURSE_NAME)
                + getSquareBracketWrappedArgument(EDGE_CASE_VALID_PARTNER_COURSE_UNIT.toString())
                + getSquareBracketWrappedArgument(EDGE_CASE_VALID_PARTNER_COURSE_DESCRIPTION),
            new PartnerCourseAddCommand(EDGE_CASE_VALID_PARTNER_COURSE));
    }
}
