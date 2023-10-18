package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_TAGS;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import java.util.stream.Stream;

import seedu.address.logic.commands.NoteAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.notes.Note;

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

        if (!areArgumentsPresent(parameterToArgMap, PARAMETER_CONTENT, PARAMETER_TAGS)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteAddCommand.NOTE_ADD_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}
        String content = ParserUtil.parseContent(parameterToArgMap.getValue(PARAMETER_CONTENT).get());
        String tags = ParserUtil.parseNoteTags(parameterToArgMap.getValue(PARAMETER_TAGS).get());

        Note note = new Note(content, tags);

        return new NoteAddCommand(note);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code SeplendidArgumentMap}.
     */
    private static boolean areArgumentsPresent(SeplendidArgumentMap argumentMap, SeplendidParameter... parameters) {
        return Stream.of(parameters).allMatch(parameter -> argumentMap.getValue(parameter).isPresent());
    }

}
