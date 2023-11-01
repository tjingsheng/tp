package seedu.address.logic.parser;


import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_INDEX;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.NoteUpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.notes.Content;

/**
 * Parses the given {@code String} of arguments in the context of the UpdateCommand
 * and returns a UpdateCommand object for execution.
 * @throws ParseException if the user input does not conform the expected format
 */
public class NoteUpdateCommandParser implements Parser<NoteUpdateCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the NoteUpdateCommand
     * and returns a NoteUpdateCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteUpdateCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            NoteUpdateCommand.NOTE_UPDATE_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_INDEX, PARAMETER_CONTENT);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_INDEX, PARAMETER_CONTENT)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteUpdateCommand.NOTE_UPDATE_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}

        try {
            Integer noteIndex = Integer.valueOf(parameterToArgMap.getValue(PARAMETER_INDEX).get());
            Content newContent = new Content(parameterToArgMap.getValue(PARAMETER_CONTENT).get());
            return new NoteUpdateCommand(noteIndex, newContent);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteUpdateCommand.NOTE_UPDATE_MESSAGE_USAGE));
        }
    }
}
