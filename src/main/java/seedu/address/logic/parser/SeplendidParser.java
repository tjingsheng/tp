package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.SeplendidLogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.LocalCourseAddCommand;
import seedu.address.logic.commands.LocalCourseCommand;
import seedu.address.logic.commands.LocalCourseListCommand;
import seedu.address.logic.commands.UniversityCommand;
import seedu.address.logic.commands.UniversityListCommand;
import seedu.address.logic.commands.NoteAddCommand;
import seedu.address.logic.commands.NoteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * Parses user input into the SEPlendid CLI.
 * <p>
 * TBD: Add parsing for help command
 */
public class SeplendidParser {

    /**
     * Used for initial separation of command, action word and arguments.
     */
    private static final Pattern COMMAND_FORMAT_WITHOUT_ARG = Pattern.compile(
            "(?<commandWord>\\S+)\\s(?<actionWord>\\S+)");
    private static final Pattern COMMAND_FORMAT_WITH_ARG = Pattern.compile(
            "(?<commandWord>\\S+)\\s(?<actionWord>\\S+)\\s(?<arguments>.*)");
    private static final Logger logger = SeplendidLogsCenter.getLogger(SeplendidParser.class);

    public Command parseNonArgumentCommand(String userInput) throws ParseException {
        final Matcher matcher = COMMAND_FORMAT_WITHOUT_ARG.matcher(userInput.trim());
        if (!matcher.matches()) {
            // Note that we are using HelpCommand from ab3
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord").trim();
        final String actionWord = matcher.group("actionWord").trim();

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Action word: " + actionWord);

        switch (commandWord) {

        case LocalCourseCommand.COMMAND_WORD:
            return getLocalCourseCommandWithoutArg(userInput, actionWord);
        // TBD: for Note

        case UniversityCommand.COMMAND_WORD:
            return getUniversityCommandWithoutArg(userInput, actionWord);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string.
     * @return the command based on the user input.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = COMMAND_FORMAT_WITH_ARG.matcher(userInput.trim());
        if (!matcher.matches()) {
            // Note that we are using HelpCommand from ab3
            return parseNonArgumentCommand(userInput);
        }

        final String commandWord = matcher.group("commandWord").trim();
        final String actionWord = matcher.group("actionWord").trim();
        final String arguments = matcher.group("arguments").trim();

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Action word: " + actionWord
                + "; Arguments: " + arguments);

        switch (commandWord) {

        case LocalCourseCommand.COMMAND_WORD:
            return getLocalCourseCommandWithArg(userInput, actionWord, arguments);

        case NoteCommand.COMMAND_WORD:
            return getNoteCommand(userInput, actionWord, arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private LocalCourseCommand getLocalCourseCommandWithArg(String userInput, String actionWord, String arguments)
            throws ParseException {
        switch (actionWord) {
        case LocalCourseAddCommand.ACTION_WORD:
            return new LocalCourseAddCommandParser().parse(arguments);
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private LocalCourseCommand getLocalCourseCommandWithoutArg(String userInput, String actionWord)
            throws ParseException {
        switch (actionWord) {
        case LocalCourseListCommand.ACTION_WORD:
            return new LocalCourseListCommand();
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
      
    private PartnerCourseAddCommand getPartnerCourseCommand(String userInput, String actionWord, String arguments)
            throws ParseException{
        switch(actionWord) {
        case PartnerCourseAddCommand.ACTION_WORD:
            return new PartnerCourseAddCommandParser().parse(arguments);
        }

    private UniversityCommand getUniversityCommandWithoutArg(String userInput, String actionWord) throws ParseException {
        switch (actionWord) {
        case UniversityListCommand.ACTION_WORD:
            return new UniversityListCommand();
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
