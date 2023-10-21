package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.UNNCESSARY_WHITESPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TestUtil.getSquareBracketWrappedArgument;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_PARTNER_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_PARTNER_COURSE_CODE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.commands.PartnerCourseCommand;
import seedu.address.logic.commands.PartnerCourseDeleteCommand;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.testutil.PartnerCourseUtil;
import seedu.address.testutil.TypicalObjects;


public class PartnerCourseDeleteCommandParserTest {
    private static final String commandActionWord = PartnerCourseCommand.COMMAND_WORD
            + " " + PartnerCourseDeleteCommand.ACTION_WORD + " ";

    private PartnerCourseDeleteCommandParser parser = new PartnerCourseDeleteCommandParser();

    @Test
    public void parse_unnecessaryWhiteSpace_success() {
        PartnerCode expectedPartnerCode = COMP1000.getPartnerCode();

        // add unnecessary whitespace
        assertParseSuccess(parser, UNNCESSARY_WHITESPACE
                        + PartnerCourseCommand.COMMAND_WORD
                        + UNNCESSARY_WHITESPACE
                        + PartnerCourseAddCommand.ACTION_WORD
                        + UNNCESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(expectedPartnerCode.getValue())
                        + UNNCESSARY_WHITESPACE,
                new PartnerCourseDeleteCommand(expectedPartnerCode));
    }

    @Test
    void parse_argumentNotClosedOrEmpty_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                PartnerCourseDeleteCommand.PARTNER_COURSE_DELETE_MESSAGE_USAGE);

        // missing open bracket
        assertParseFailure(parser, commandActionWord
                + PartnerCourseUtil.getPartnerCourseArgumentsForDeleteCommand(TypicalObjects.COMP1000).substring(
                1), expectedMessage);

        // empty argument
        assertParseFailure(parser, commandActionWord
                + getSquareBracketWrappedArgument(""), expectedMessage);
    }


    @Test
    public void parse_allArgumentMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                PartnerCourseDeleteCommand.PARTNER_COURSE_DELETE_MESSAGE_USAGE);

        // all arguments missing
        assertParseFailure(parser, commandActionWord, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid localCode
        assertParseFailure(parser, commandActionWord
                        + getSquareBracketWrappedArgument(INVALID_PARTNER_COURSE_CODE),
                PartnerCode.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_edgeCasePartnerNameValue_success() {
        assertParseSuccess(parser, commandActionWord
                        + getSquareBracketWrappedArgument(EDGE_CASE_VALID_PARTNER_COURSE_CODE),
                new PartnerCourseDeleteCommand(EDGE_CASE_VALID_PARTNER_COURSE.getPartnerCode()));
    }
}
