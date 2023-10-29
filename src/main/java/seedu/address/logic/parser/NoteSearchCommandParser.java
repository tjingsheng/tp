package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_TAGS;

import seedu.address.logic.commands.NoteSearchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.notes.NoteTagContainsKeywordsPredicate;
import seedu.address.model.tag.Tag;

/**
 * Parses the given {@code String} of arguments in the context of the SearchCommand
 * and returns a SearchCommand object for execution.
 * @throws ParseException if the user input does not conform the expected format
 */
public class NoteSearchCommandParser implements Parser<NoteSearchCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the NoteSearchCommand
     * and returns a NoteSearchCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteSearchCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            NoteSearchCommand.NOTE_SEARCH_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_TAGS);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_TAGS)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteSearchCommand.NOTE_SEARCH_MESSAGE_USAGE));
        }

        Tag tag = ParserUtil.parseTag(
                parameterToArgMap.getValue(PARAMETER_TAGS).get());
        return new NoteSearchCommand(new NoteTagContainsKeywordsPredicate(tag.toString()));

    }
}
