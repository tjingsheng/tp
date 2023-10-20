package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.UNNCESSARY_WHITESPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TestUtil.getSquareBracketWrappedArgument;
import static seedu.address.testutil.TypicalObjects.CS2040S;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_LOCAL_COURSE;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_LOCAL_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_CODE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.LocalCourseAddCommand;
import seedu.address.logic.commands.LocalCourseCommand;
import seedu.address.logic.commands.LocalCourseDeleteCommand;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.testutil.LocalCourseUtil;
import seedu.address.testutil.TypicalObjects;

public class LocalCourseDeleteCommandParserTest {

    private static final String commandActionWord = LocalCourseCommand.COMMAND_WORD
            + " " + LocalCourseDeleteCommand.ACTION_WORD + " ";

    private LocalCourseDeleteCommandParser parser = new LocalCourseDeleteCommandParser();

    @Test
    public void parse_unnecessaryWhiteSpace_success() {
        LocalCode expectedLocalCode = CS2040S.getLocalCode();

        // add unnecessary whitespace
        assertParseSuccess(parser, UNNCESSARY_WHITESPACE
                        + LocalCourseCommand.COMMAND_WORD
                        + UNNCESSARY_WHITESPACE
                        + LocalCourseAddCommand.ACTION_WORD
                        + UNNCESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(expectedLocalCode.getValue())
                        + UNNCESSARY_WHITESPACE,
                new LocalCourseDeleteCommand(expectedLocalCode));
    }

    @Test
    void parse_argumentNotClosedOrEmpty_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                LocalCourseDeleteCommand.LOCAL_COURSE_DELETE_MESSAGE_USAGE);

        // missing open bracket
        assertParseFailure(parser, commandActionWord
                + LocalCourseUtil.getLocalCourseArgumentsForDeleteCommand(TypicalObjects.CS3230).substring(
                1), expectedMessage);

        // empty argument
        assertParseFailure(parser, commandActionWord
                + getSquareBracketWrappedArgument(""), expectedMessage);
    }


    @Test
    public void parse_allArgumentMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                LocalCourseDeleteCommand.LOCAL_COURSE_DELETE_MESSAGE_USAGE);

        // all arguments missing
        assertParseFailure(parser, commandActionWord, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid localCode
        assertParseFailure(parser, commandActionWord
                        + getSquareBracketWrappedArgument(INVALID_LOCAL_COURSE_CODE),
                LocalCode.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_edgeCaseLocalNameValue_success() {
        assertParseSuccess(parser, commandActionWord
                        + getSquareBracketWrappedArgument(EDGE_CASE_VALID_LOCAL_COURSE_CODE),
                new LocalCourseDeleteCommand(EDGE_CASE_VALID_LOCAL_COURSE.getLocalCode()));
    }
}
