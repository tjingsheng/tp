package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Abstract class for MappingCommands.
 */
public abstract class MappingCommand extends Command {

    public static final String COMMAND_WORD = "mapping";

    /* The message shown upon a ParseException */
    private static final String MESSAGE_USAGE = COMMAND_WORD + ": Mappings stored in SEPlendid"
            + "Commands: "
            + "mapping list: Lists all available mappings."
            + "mapping add [localcode] [university] [partnercode] [information]: Adds a mapping."
            + "mapping delete [localcode] [university] [partnercode] [information]: Deletes a mapping."
            + "mapping edit [localcode] [university] [partnercode] [information]: Edits a mapping."
            + "mapping sort [attribute]: Sorts the mappings by the specified attribute."
            + "mapping search [keyword]: Finds the mappings by the specified keyword.";

    protected MappingCommand() {
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
