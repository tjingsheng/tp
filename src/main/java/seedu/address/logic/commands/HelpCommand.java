package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }

    /**
     * TBD: This stub is to be removed after morphing is complete.
     *
     * @param model {@code Model} which the command should operate on.
     * @return Nothing.
     * @throws CommandException Always.
     */
    @Override
    public CommandResult execute(SeplendidModel model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }
}
