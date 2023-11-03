package seedu.address.logic.parser.note;


import static seedu.address.logic.parser.CliSyntax.PARAMETER_INDEX;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.UsageMessage;
import seedu.address.logic.commands.note.NoteDeleteCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and deletes a Note object.
 */
public class NoteDeleteCommandParser implements Parser<NoteDeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the NoteAddCommand
     * and returns an NoteAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteDeleteCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(UsageMessage.NOTE_DELETE.getValue());
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_INDEX);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_INDEX)) {
            throw new ParseException(UsageMessage.NOTE_DELETE.getValue());
        }

        // All arguments should be a non-empty {@code Optional}
        Integer noteIndex = Integer.valueOf(parameterToArgMap.getValue(PARAMETER_INDEX).get());

        return new NoteDeleteCommand(noteIndex);
    }

}
