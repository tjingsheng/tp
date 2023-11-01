package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_INDEX;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_TAGS;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.NoteTagCommand;
import seedu.address.logic.commands.NoteUpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

/**
 * Parses the given {@code String} of arguments in the context of the TagCommand
 * and returns a TagCommand object for execution.
 * @throws ParseException if the user input does not conform the expected format
 */
public class NoteTagCommandParser implements Parser<NoteTagCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the NoteUpdateCommand
     * and returns a NoteUpdateCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteTagCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            NoteUpdateCommand.NOTE_UPDATE_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_INDEX, PARAMETER_TAGS);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_INDEX, PARAMETER_TAGS)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteUpdateCommand.NOTE_UPDATE_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}

        try {
            Integer noteIndex = Integer.valueOf(parameterToArgMap.getValue(PARAMETER_INDEX).get());
            Tag newTag = new Tag(parameterToArgMap.getValue(PARAMETER_TAGS).get());
            return new NoteTagCommand(noteIndex, newTag);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteUpdateCommand.NOTE_UPDATE_MESSAGE_USAGE));
        }
    }
}
