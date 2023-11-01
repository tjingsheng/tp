package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.notes.Content;
import seedu.address.model.notes.Note;
import seedu.address.model.notes.exceptions.NoteNotFoundException;
import seedu.address.seplendidui.UiUtil;

import static java.util.Objects.requireNonNull;

public class NoteUpdateCommand extends NoteCommand {

    public static final String NOTE_UPDATE_MESSAGE_USAGE = COMMAND_WORD
            + " update [index] [content]: Updates a note to the specified content.";
    public static final String ACTION_WORD = "update";
    public static final String MESSAGE_SUCCESS = "Note updated: %1$s";
    private final Integer noteIndexToUpdate;
    private final Content updateContent;

    /**
     * Creates a NoteAddCommand to add the specified {@code Note}
     *
     * @param note The Note to be added into Storage.
     */
    public NoteUpdateCommand(int noteIndexToUpdate, Content updateContent) {
        super();
        requireNonNull(noteIndexToUpdate);
        this.noteIndexToUpdate = noteIndexToUpdate;
        this.updateContent = updateContent;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);
        int noteListSize = seplendidModel.getNoteCatalogue().getNoteList().size();
        if (noteListSize < this.noteIndexToUpdate) {
            throw new CommandException("Note not found, please put a valid index.");
        }
        Note oldNote = seplendidModel.getNoteCatalogue().getNoteList().get(this.noteIndexToUpdate - 1);
        Note newNote = new Note(this.updateContent, oldNote.getTags(), oldNote.getIndex());
        seplendidModel.setNote(oldNote, newNote);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(newNote)),
                UiUtil.ListViewModel.NOTE_LIST);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NoteUpdateCommand)) {
            return false;
        }

        NoteUpdateCommand otherNoteDeleteCommand = (NoteUpdateCommand) other;
        return noteIndexToUpdate.equals(otherNoteDeleteCommand.noteIndexToUpdate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("noteToUpdate", noteIndexToUpdate)
                .toString();
    }
}
