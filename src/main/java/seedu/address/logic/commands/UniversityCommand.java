package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Abstract class for UniversityCommands.
 */
public abstract class UniversityCommand extends Command {
    public static final String COMMAND_WORD = "university";

    private static final String MESSAGE_USAGE = COMMAND_WORD + ": Universities given by NUS Computing"
            + "Commands: "
            + "university list: Lists all available universities."
            + "university search [university name]."
            + "university sort [university]";

    protected UniversityCommand() {
    }

    @Override
    public boolean equals(Object other) {
        return other == this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
