package seedu.address.logic.parser.note;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_TAGS;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.note.NoteAddCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.note.Content;
import seedu.address.model.note.Note;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new Note object.
 */
public class NoteAddCommandParser implements Parser<NoteAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the NoteAddCommand
     * and returns an NoteAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteAddCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            NoteAddCommand.NOTE_ADD_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_CONTENT, PARAMETER_TAGS);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_CONTENT, PARAMETER_TAGS)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteAddCommand.NOTE_ADD_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}
        Content content = ParserUtil.parseContent(parameterToArgMap.getValue(PARAMETER_CONTENT).get());
        Tag tags = ParserUtil.parseTag(parameterToArgMap.getValue(PARAMETER_TAGS).get());

        Note note = new Note(content, tags);

        return new NoteAddCommand(note);
    }

}
