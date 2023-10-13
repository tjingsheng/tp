package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true);
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
