package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.UniversitySearchCommand;
import seedu.address.model.university.UniversityNameContainsKeywordsPredicate;
public class UniversitySearchCommandParserTest {
    private UniversitySearchCommandParser parser = new UniversitySearchCommandParser();


    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UniversitySearchCommand.UNIVERSITY_SEARCH_MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsUniversitySearchCommand() {
        // no leading and trailing whitespaces
        UniversitySearchCommand expectedUniversitySearchCommand =
                new UniversitySearchCommand(new UniversityNameContainsKeywordsPredicate(
                        "Stanford"));
        assertParseSuccess(parser, "Stanford Seoul", expectedUniversitySearchCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Stanford \n \t Seoul \t", expectedUniversitySearchCommand);
    }

}
