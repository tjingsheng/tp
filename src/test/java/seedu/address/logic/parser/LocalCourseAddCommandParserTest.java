package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.UNNCESSARY_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.getSquareBracketWrappedArgument;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_LOCAL_COURSE;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_LOCAL_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_LOCAL_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE_CODE;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE_NAME;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.LocalCourseAddCommand;
import seedu.address.logic.commands.LocalCourseCommand;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.testutil.LocalCourseBuilder;
import seedu.address.testutil.LocalCourseUtil;
import seedu.address.testutil.TypicalObjects;

public class LocalCourseAddCommandParserTest {

    private static final String commandActionWord = LocalCourseCommand.COMMAND_WORD
            + " " + LocalCourseAddCommand.ACTION_WORD + " ";

    private LocalCourseAddCommandParser parser = new LocalCourseAddCommandParser();

    @Test
    public void parse_unnecessaryWhiteSpace_success() {
        LocalCourse expectedLocalCourse = new LocalCourseBuilder(TypicalObjects.CS2040S).build();

        // add unnecessary whitespace
        assertParseSuccess(parser, UNNCESSARY_WHITESPACE
                        + LocalCourseCommand.COMMAND_WORD
                        + UNNCESSARY_WHITESPACE
                        + LocalCourseAddCommand.ACTION_WORD
                        + UNNCESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(expectedLocalCourse.getLocalCode().getValue())
                        + UNNCESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument(expectedLocalCourse.getLocalName().getValue())
                        + UNNCESSARY_WHITESPACE,
                new LocalCourseAddCommand(expectedLocalCourse));
    }

    @Test
    void parse_argumentNotClosedOrEmpty_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                LocalCourseAddCommand.LOCAL_COURSE_ADD_MESSAGE_USAGE);

        // missing open bracket
        assertParseFailure(parser, commandActionWord
                + LocalCourseUtil.getLocalCourseArgumentsForCommand(TypicalObjects.CS3230).substring(
                1), expectedMessage);

        // empty argument
        assertParseFailure(parser, commandActionWord
                + getSquareBracketWrappedArgument(TYPICAL_LOCAL_COURSE_CODE)
                + " "
                + getSquareBracketWrappedArgument(""), expectedMessage);
    }


    @Test
    public void parse_allArgumentMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                LocalCourseAddCommand.LOCAL_COURSE_ADD_MESSAGE_USAGE);

        // missing localcode argument
        assertParseFailure(parser, commandActionWord
                        + getSquareBracketWrappedArgument(TYPICAL_LOCAL_COURSE_NAME),
                expectedMessage);

        // missing localname prefix
        assertParseFailure(parser, commandActionWord
                        + getSquareBracketWrappedArgument(TYPICAL_LOCAL_COURSE_CODE),
                expectedMessage);

        // all arguments missing
        assertParseFailure(parser, commandActionWord, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid localCode
        assertParseFailure(parser, commandActionWord
                        + getSquareBracketWrappedArgument(INVALID_LOCAL_COURSE_CODE)
                        + " " + getSquareBracketWrappedArgument(TYPICAL_LOCAL_COURSE_NAME),
                LocalCode.MESSAGE_CONSTRAINTS);

        // invalid localName
        // This test also ensures that the input to checkArgument and parseLocalName matches.
        // localName is trimmed before checkArgument, as a standardisation
        // Therefore a localName argument starting with a whitespace will pass,
        // while a whitespace alone will not. A whitespace alone will trigger
        // ParseException due to ParserUtil#areValuesEncloseAndNonEmpty.
        assertParseFailure(parser, commandActionWord
                        + getSquareBracketWrappedArgument(TYPICAL_LOCAL_COURSE_CODE)
                        + " " + getSquareBracketWrappedArgument(INVALID_LOCAL_COURSE_NAME),
                String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        LocalCourseAddCommand.LOCAL_COURSE_ADD_MESSAGE_USAGE));
    }

    @Test
    public void parse_edgeCaseLocalNameValue_success() {
        assertParseSuccess(parser, commandActionWord
                        + getSquareBracketWrappedArgument(EDGE_CASE_VALID_LOCAL_COURSE_CODE)
                        + " " + getSquareBracketWrappedArgument(EDGE_CASE_VALID_LOCAL_COURSE_NAME),
                new LocalCourseAddCommand(EDGE_CASE_VALID_LOCAL_COURSE));
    }
}
