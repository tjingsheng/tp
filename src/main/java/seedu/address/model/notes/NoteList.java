package seedu.address.model.notes;

import java.util.ArrayList;

/**
 * Represents a list of all the notes in SEPlendid
 */
public class NoteList {
    private final ArrayList<Note> notesList;

    /**
     * Constructs an {@code NoteList}.
     */
    public NoteList() {
        this.notesList = new ArrayList<>();
    }

    /**
     * Gets the notesList.
     */
    public ArrayList<Note> getNotesList() {
        return notesList;
    }

    /**
     * Adds a new note into the note list.
     * @param note The note that we want to add.
     * @return The NoteList object.
     */
    public NoteList addNote(Note note) {
        this.notesList.add(note);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder notes = new StringBuilder();
        for (int i = 0; i < notesList.size(); i++) {
            notes.append(notesList.get(i)).append("\n");
        }
        return notes.toString();
    }
}
