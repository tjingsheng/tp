package seedu.address.logic.commands.note;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.notes.Note;
import seedu.address.seplendidui.UiUtil;

/**
 * Adds a note to the NoteList.
 */
public class NoteAddCommand extends NoteCommand {

    // Also available in abstract class LocalCourseCommand to support polymorphism
    public static final String NOTE_ADD_MESSAGE_USAGE = COMMAND_WORD
            + "add [content] [tags]: Adds a local course.";
    public static final String ACTION_WORD = "add";

    public static final String MESSAGE_SUCCESS = "New note added: %1$s";

    private final Note noteToAdd;

    /**
     * Creates a NoteAddCommand to add the specified {@code Note}
     *
     * @param note The Note to be added into Storage.
     */
    public NoteAddCommand(Note note) {
        super();
        requireNonNull(note);
        noteToAdd = note;
    }

    /**
     * TBD: This stub is to be removed after morphing is complete.
     *
     * @param model {@code Model} which the command should operate on.
     * @return Nothing.
     * @throws CommandException Always.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);

        seplendidModel.addNote(noteToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(noteToAdd)),
                UiUtil.ListViewModel.NOTE_LIST);

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NoteAddCommand)) {
            return false;
        }

        NoteAddCommand otherNoteAddCommand = (NoteAddCommand) other;
        return noteToAdd.equals(otherNoteAddCommand.noteToAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("noteToAdd", noteToAdd)
                .toString();
    }
}
