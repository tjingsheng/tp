package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Abstract class for NoteCommands.
 */
public abstract class NoteCommand extends Command {

    public static final String COMMAND_WORD = "note";

    /* The message shown upon a ParseException */
    private static final String MESSAGE_USAGE = COMMAND_WORD + ": Courses offered by NUS Computing"
            + "Commands: "
            + "note list: Lists all notess."
            + "note add [content] : Adds a note without tags."
            + "note add [content] [tags]: Adds a note with tags.";

    protected NoteCommand() {
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
