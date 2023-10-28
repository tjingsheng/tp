package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.UNNCESSARY_WHITESPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TestUtil.getSquareBracketWrappedArgument;
import static seedu.address.testutil.TypicalObjects.INVALID_LOCAL_COURSE_ATTRIBUTE;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.LocalCourseCommand;
import seedu.address.logic.commands.LocalCourseSortCommand;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalCode;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalName;
import seedu.address.testutil.LocalCourseUtil;

public class LocalCourseSortCommandParserTest {

    private static final String commandActionWord = LocalCourseCommand.COMMAND_WORD
            + LocalCourseSortCommand.ACTION_WORD;

    private LocalCourseSortCommandParser parser = new LocalCourseSortCommandParser();

    @Test
    public void parse_unnecessaryWhiteSpace_success() {
        Comparator<LocalCourse> expectedComparator = new LocalCourseComparatorByLocalCode();

        // add unnecessary whitespace
        assertParseSuccess(parser, UNNCESSARY_WHITESPACE
                        + LocalCourseCommand.COMMAND_WORD
                        + UNNCESSARY_WHITESPACE
                        + LocalCourseSortCommand.ACTION_WORD
                        + UNNCESSARY_WHITESPACE
                        + getSquareBracketWrappedArgument("localcode")
                        + UNNCESSARY_WHITESPACE,
                new LocalCourseSortCommand(expectedComparator));
    }

    @Test
    public void parse_argumentNotClosedOrEmpty_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                LocalCourseSortCommand.LOCAL_COURSE_SORT_MESSAGE_USAGE);

        // missing open bracket
        assertParseFailure(parser, commandActionWord
                + LocalCourseUtil.getLocalCourseArgumentsForSortCommand(new LocalCourseComparatorByLocalCode())
                .substring(1), expectedMessage);

        // empty argument
        assertParseFailure(parser, commandActionWord
                + getSquareBracketWrappedArgument(""), expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid attribute
        assertParseFailure(parser, commandActionWord
                + getSquareBracketWrappedArgument(INVALID_LOCAL_COURSE_ATTRIBUTE),
                LocalCourseAttribute.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_validArguments_success() {
        assertParseSuccess(parser, commandActionWord
                + getSquareBracketWrappedArgument(LocalCourseAttribute.LOCALCODE.toString()),
                new LocalCourseSortCommand(new LocalCourseComparatorByLocalCode()));

        assertParseSuccess(parser, commandActionWord
                        + getSquareBracketWrappedArgument(LocalCourseAttribute.LOCALNAME.toString()),
                new LocalCourseSortCommand(new LocalCourseComparatorByLocalName()));

    }
}
