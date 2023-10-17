package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_TAGS;

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
     * Returns true if all arguments are enclosed in square brackets, and are non-empty.
     *
     * @param args Arguments in the format of {@code [args1] [args2] ...}.
     * @return true if in correct format.
     */
    private static boolean areValuesEnclosedAndNonEmpty(String args) {
        // The number of unclosed open square brackets, used to validate input.
        int bracketCount = 0;
        StringBuilder currValue = new StringBuilder();

        for (int i = 0; i < args.length(); i++) {
            Character currChar = args.charAt(i);
            if (currChar.equals('[')) {
                currValue.setLength(0);
                bracketCount++;
            } else if (currChar.equals(']') && currValue.toString().trim().isEmpty()) {
                return false;
            } else if (currChar.equals(']')) {
                bracketCount--;
            } else {
                currValue.append(currChar);
            }

            if (bracketCount < 0 || bracketCount > 1) {
                return false;
            }
        }

        return bracketCount == 0;
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code SeplendidArgumentMap}.
     */
    private static boolean areArgumentsPresent(SeplendidArgumentMap argumentMap, SeplendidParameter... parameters) {
        return Stream.of(parameters).allMatch(parameter -> argumentMap.getValue(parameter).isPresent());
    }

}
