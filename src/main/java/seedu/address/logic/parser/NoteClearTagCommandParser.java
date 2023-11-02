package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_INDEX;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.NoteClearTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses the given {@code String} of arguments in the context of the ClearTagCommand
 * and returns a ClearTagCommand object for execution.
 * @throws ParseException if the user input does not conform the expected format
 */
public class NoteClearTagCommandParser implements Parser<NoteClearTagCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the NoteClearTagCommand
     * and returns a NoteClearTagCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteClearTagCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            NoteClearTagCommand.NOTE_CLEAR_TAG_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_INDEX);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_INDEX)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteClearTagCommand.NOTE_CLEAR_TAG_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}

        try {
            Integer noteIndex = Integer.valueOf(parameterToArgMap.getValue(PARAMETER_INDEX).get());
            return new NoteClearTagCommand(noteIndex);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteClearTagCommand.NOTE_CLEAR_TAG_MESSAGE_USAGE));
        }
    }
}
