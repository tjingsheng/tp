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
 * Deletes a note to the NoteList.
 */
public class NoteDeleteCommand extends NoteCommand {

    // Also available in abstract class LocalCourseCommand to support polymorphism
    public static final String NOTE_DELETE_MESSAGE_USAGE = COMMAND_WORD
            + " delete [index]: Deletes a note.";
    public static final String ACTION_WORD = "delete";

    public static final String MESSAGE_SUCCESS = "Note deleted: %1$s";

    private final Integer noteIndexToDelete;

    /**
     * Creates a NoteAddCommand to add the specified {@code Note}
     *
     * @param note The Note to be added into Storage.
     */
    public NoteDeleteCommand(int note) {
        super();
        requireNonNull(note);
        noteIndexToDelete = note;
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

        Note deletedNote = seplendidModel.deleteNote(noteIndexToDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(deletedNote)),
                UiUtil.ListViewModel.NOTE_LIST);

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NoteDeleteCommand)) {
            return false;
        }

        NoteDeleteCommand otherNoteDeleteCommand = (NoteDeleteCommand) other;
        return noteIndexToDelete.equals(otherNoteDeleteCommand.noteIndexToDelete);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("noteToDelete", noteIndexToDelete)
                .toString();
    }
}
