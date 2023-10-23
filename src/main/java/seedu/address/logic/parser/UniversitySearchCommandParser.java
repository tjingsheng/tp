package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERNAME;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITY;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITYNAME;

import java.util.Arrays;

import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.commands.UniversitySearchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;
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
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            UniversitySearchCommand.UNIVERSITY_SEARCH_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_UNIVERSITYNAME);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_UNIVERSITYNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UniversitySearchCommand.UNIVERSITY_SEARCH_MESSAGE_USAGE));
        }

        UniversityName universityName = ParserUtil.parseUniversityName(parameterToArgMap.getValue(PARAMETER_UNIVERSITYNAME).get());
        return new UniversitySearchCommand(new UniversityNameContainsKeywordsPredicate(universityName.getName()));

    }
}

