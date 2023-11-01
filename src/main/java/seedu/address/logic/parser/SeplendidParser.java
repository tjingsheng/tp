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
import seedu.address.logic.commands.LocalCourseDeleteCommand;
import seedu.address.logic.commands.LocalCourseListCommand;
import seedu.address.logic.commands.LocalCourseSortCommand;
import seedu.address.logic.commands.MappingAddCommand;
import seedu.address.logic.commands.MappingCommand;
import seedu.address.logic.commands.MappingDeleteCommand;
import seedu.address.logic.commands.MappingListCommand;
import seedu.address.logic.commands.MappingSearchCommand;
import seedu.address.logic.commands.NoteAddCommand;
import seedu.address.logic.commands.NoteCommand;
import seedu.address.logic.commands.NoteListCommand;
import seedu.address.logic.commands.NoteSearchCommand;
import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.commands.PartnerCourseCommand;
import seedu.address.logic.commands.PartnerCourseDeleteCommand;
import seedu.address.logic.commands.PartnerCourseListCommand;
import seedu.address.logic.commands.PartnerCourseSortCommand;
import seedu.address.logic.commands.UniversityCommand;
import seedu.address.logic.commands.UniversityListCommand;
import seedu.address.logic.commands.UniversitySearchCommand;
import seedu.address.logic.commands.UniversitySortCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input into the SEPlendid CLI.
 * <p>
 * TBD: Add parsing for help command
 */
public class SeplendidParser {
    /**
     * Used for initial separation of command, action word and arguments.
     */
    private static final String REGEX_GROUP_COMMAND_WORD = "commandWord";
    private static final String REGEX_GROUP_ACTION_WORD = "actionWord";
    private static final String REGEX_GROUP_ARGUMENTS = "arguments";
    private static final Pattern COMMAND_FORMAT_COMMAND = Pattern.compile(String.format(
        "(?<%s>\\S+)",
        REGEX_GROUP_COMMAND_WORD));
    private static final Pattern COMMAND_FORMAT_COMMAND_ACTION = Pattern.compile(String.format(
        "(?<%s>\\S+)\\s(?<%s>\\S+)",
        REGEX_GROUP_COMMAND_WORD,
        REGEX_GROUP_ACTION_WORD));
    private static final Pattern COMMAND_FORMAT_COMMAND_ACTION_ARG = Pattern.compile(String.format(
        "(?<%s>\\S+)\\s(?<%s>\\S+)\\s(?<%s>.*)",
        REGEX_GROUP_COMMAND_WORD,
        REGEX_GROUP_ACTION_WORD,
        REGEX_GROUP_ARGUMENTS));
    private static final Logger logger = SeplendidLogsCenter.getLogger(SeplendidParser.class);

    /**
     * Parses user input into command for execution.
     * Determines the pattern of the command.
     *
     * @param userInput full user input string.
     * @return the command based on the user input.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public Command parseCommand(String userInput) throws ParseException {
        // Trim the user input
        userInput = userInput.trim();

        // Check which pattern the input matches
        if (COMMAND_FORMAT_COMMAND_ACTION_ARG.matcher(userInput).matches()) {
            return parseCommandActionArg(userInput);
        } else if (COMMAND_FORMAT_COMMAND_ACTION.matcher(userInput).matches()) {
            return parseCommandAction(userInput);
        } else if (COMMAND_FORMAT_COMMAND.matcher(userInput).matches()) {
            return parseCommandOnly(userInput);
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
    }

    /**
     * Parses a command with no action word and no arguments.
     *
     * @param userInput String of userInput
     * @return the command based on the user input.
     * @throws ParseException If the input is invalid.
     */
    public Command parseCommandOnly(String userInput) throws ParseException {
        final Matcher matcher = COMMAND_FORMAT_COMMAND.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group(REGEX_GROUP_COMMAND_WORD).trim();
        if (commandWord.equals(HelpCommand.COMMAND_WORD)) {
            return new HelpCommand();
        }

        logger.finer("This user input caused a ParseException: " + userInput);
        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
    }

    /**
     * Parses a command with an action word and no arguments.
     *
     * @param userInput String of userInput
     * @return the command based on the user input.
     * @throws ParseException If the input is invalid.
     */
    public Command parseCommandAction(String userInput) throws ParseException {
        final Matcher matcher = COMMAND_FORMAT_COMMAND_ACTION.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group(REGEX_GROUP_COMMAND_WORD).trim();
        final String actionWord = matcher.group(REGEX_GROUP_ACTION_WORD).trim();

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Action word: " + actionWord);

        switch (commandWord) {

        case LocalCourseCommand.COMMAND_WORD:
            return getLocalCourseCommandWithoutArg(userInput, actionWord);

        case PartnerCourseCommand.COMMAND_WORD:
            return getPartnerCourseCommandWithoutArg(userInput, actionWord);

        case UniversityCommand.COMMAND_WORD:
            return getUniversityCommandWithoutArg(userInput, actionWord);

        case MappingCommand.COMMAND_WORD:
            return getMappingCommandWithoutArg(userInput, actionWord);

        case NoteCommand.COMMAND_WORD:
            return getNoteCommandWithoutArg(userInput, actionWord);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
    }

    /**
     * Parses a command with an action word and contains arguments.
     *
     * @param userInput String of userInput
     * @return the command based on the user input.
     * @throws ParseException If the input is invalid.
     */
    public Command parseCommandActionArg(String userInput) throws ParseException {
        final Matcher matcher = COMMAND_FORMAT_COMMAND_ACTION_ARG.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        final String commandWord = matcher.group(REGEX_GROUP_COMMAND_WORD).trim();
        final String actionWord = matcher.group(REGEX_GROUP_ACTION_WORD).trim();
        final String arguments = matcher.group(REGEX_GROUP_ARGUMENTS).trim();

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Action word: " + actionWord + "; Arguments: " + arguments);

        switch (commandWord) {

        case LocalCourseCommand.COMMAND_WORD:
            return getLocalCourseCommandWithArg(userInput, actionWord, arguments);

        case PartnerCourseCommand.COMMAND_WORD:
            return getPartnerCourseCommandWithArg(userInput, actionWord, arguments);

        case NoteCommand.COMMAND_WORD:
            return getNoteCommandWithArg(userInput, actionWord, arguments);

        case UniversityCommand.COMMAND_WORD:
            return getUniversityCommandWithArg(userInput, actionWord, arguments);

        case MappingCommand.COMMAND_WORD:
            return getMappingCommandWithArg(userInput, actionWord, arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
    }

    private LocalCourseCommand getLocalCourseCommandWithArg(String userInput, String actionWord, String arguments)
                throws ParseException {
        switch (actionWord) {
        case LocalCourseAddCommand.ACTION_WORD:
            return new LocalCourseAddCommandParser().parse(arguments);
        case LocalCourseDeleteCommand.ACTION_WORD:
            return new LocalCourseDeleteCommandParser().parse(arguments);
        case LocalCourseSortCommand.ACTION_WORD:
            return new LocalCourseSortCommandParser().parse(arguments);
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
    }

    private PartnerCourseCommand getPartnerCourseCommandWithArg(String userInput, String actionWord, String arguments)
                throws ParseException {
        switch (actionWord) {
        case PartnerCourseAddCommand.ACTION_WORD:
            return new PartnerCourseAddCommandParser().parse(arguments);
        case PartnerCourseDeleteCommand.ACTION_WORD:
            return new PartnerCourseDeleteCommandParser().parse(arguments);
        case PartnerCourseSortCommand.ACTION_WORD:
            return new PartnerCourseSortCommandParser().parse(arguments);
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private MappingCommand getMappingCommandWithArg(String userInput, String actionWord, String arguments)
                throws ParseException {
        switch (actionWord) {
        case MappingAddCommand.ACTION_WORD:
            return new MappingAddCommandParser().parse(arguments);
        case MappingDeleteCommand.ACTION_WORD:
            return new MappingDeleteCommandParser().parse(arguments);
        case MappingSearchCommand.ACTION_WORD:
            return new MappingSearchCommandParser().parse(arguments);
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private PartnerCourseCommand getPartnerCourseCommandWithoutArg(String userInput, String actionWord)
                throws ParseException {
        switch (actionWord) {
        case PartnerCourseListCommand.ACTION_WORD:
            return new PartnerCourseListCommand();
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private UniversityCommand getUniversityCommandWithoutArg(String userInput, String actionWord)
                throws ParseException {
        switch (actionWord) {
        case UniversityListCommand.ACTION_WORD:
            return new UniversityListCommand();
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private UniversityCommand getUniversityCommandWithArg(String userInput, String actionWord, String arguments)
                throws ParseException {
        switch (actionWord) {
        case UniversitySearchCommand.ACTION_WORD:
            return new UniversitySearchCommandParser().parse(arguments);
        case UniversitySortCommand.ACTION_WORD:
            return new UniversitySortCommandParser().parse(arguments);
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private MappingCommand getMappingCommandWithoutArg(String userInput, String actionWord) throws ParseException {
        switch (actionWord) {
        case MappingListCommand.ACTION_WORD:
            return new MappingListCommand();
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private NoteCommand getNoteCommandWithArg(String userInput, String actionWord, String arguments)
                throws ParseException {
        switch (actionWord) {
        case NoteAddCommand.ACTION_WORD:
            return new NoteAddCommandParser().parse(arguments);
        case NoteSearchCommand.ACTION_WORD:
            return new NoteSearchCommandParser().parse(arguments);
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private NoteCommand getNoteCommandWithoutArg(String userInput, String actionWord) throws ParseException {
        switch (actionWord) {
        case NoteListCommand.ACTION_WORD:
            return new NoteListCommand();
        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
