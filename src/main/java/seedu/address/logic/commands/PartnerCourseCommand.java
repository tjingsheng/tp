package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Abstract class for PartnerCourseCommands.
 */
public abstract class PartnerCourseCommand extends Command {
    public static final String COMMAND_WORD = "partnercourse";

    private static final String MESSAGE_USAGE = COMMAND_WORD + ": Courses offered by partner universities"
            + "Commands: "
            + "partnercourse list: Lists all available partner courses."
            + "partnercourse add [university] [partnercode] [partnername]: Adds a partner course."
            + "partnercourse delete [partnercode]: Deletes a partner course.";

    protected PartnerCourseCommand() {

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
