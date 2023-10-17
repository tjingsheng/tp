package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.SeplendidLogsCenter;
import seedu.address.logic.commands.*;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input into the SEPlendid CLI.
 */
public class SeplendidParser {

    /**
     * Used for initial separation of command, action word and arguments.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile(
            "(?<commandWord>\\S+)\\s(?<actionWord>\\S+)\\s(?<arguments>.*)");
    private static final Logger logger = SeplendidLogsCenter.getLogger(SeplendidParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string.
     * @return the command based on the user input.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            // Note that we are using HelpCommand from ab3
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String actionWord = matcher.group("actionWord");
        final String arguments = matcher.group("arguments");

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Action word: " + actionWord
                + "; Arguments: " + arguments);

        switch (commandWord) {

        case LocalCourseCommand.COMMAND_WORD:
            return getLocalCourseCommand(userInput, actionWord, arguments);
        case NoteCommand.COMMAND_WORD:
            return getNoteCommand(userInput, actionWord, arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private LocalCourseAddCommand getLocalCourseCommand(String userInput, String actionWord, String arguments)
            throws ParseException {
        switch (actionWord) {
        case LocalCourseAddCommand.ACTION_WORD:
            return new LocalCourseAddCommandParser().parse(arguments);
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private NoteAddCommand getNoteCommand(String userInput, String actionWord, String arguments)
            throws ParseException {
        switch (actionWord) {
            case NoteAddCommand.ACTION_WORD:
                return new NoteAddCommandParser().parse(arguments);
            default:
                logger.finer("This user input caused a ParseException: " + userInput);
                throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
