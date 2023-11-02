package seedu.address.logic.commands.localcourse;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.Command;

/**
 * Abstract class for LocalCourseCommands.
 */
public abstract class LocalCourseCommand extends Command {

    public static final String COMMAND_WORD = "localcourse";

    /* The message shown upon a ParseException */
    private static final String MESSAGE_USAGE = COMMAND_WORD + ": Courses offered by NUS Computing"
            + "Commands: "
            + "localcourse list: Lists all available local courses."
            + "localcourse add [localcode] [localname] [localunit] [localdescription]: Adds a local course."
            + "localcourse delete [localcode]";

    protected LocalCourseCommand() {
    }

    // Ensure that this method is overridden in all subclasses
    @Override
    public boolean equals(Object other) {
        return other == this;
    }

    // Ensure that this method is overridden in all subclasses
    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }

}
