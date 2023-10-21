package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.UniversitySearchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.university.UniversityNameContainsKeywordsPredicate;

/**
 * Parses the given {@code String} of arguments in the context of the SearchCommand
 * and returns a SearchCommand object for execution.
 * @throws ParseException if the user input does not conform the expected format
 */

public class UniversitySearchCommandParser implements Parser<UniversitySearchCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UniversitySearchCommand
     * and returns a UniversitySearchCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UniversitySearchCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            UniversitySearchCommand.UNIVERSITY_SEARCH_MESSAGE_USAGE));
        }
        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new UniversitySearchCommand(new UniversityNameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }
}

