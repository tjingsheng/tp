package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.notes.Note;

/**
 * Unmodifiable view of note catalogue.
 */
public interface ReadOnlyNoteCatalogue {

    /**
     * Returns an unmodifiable view of the local course list.
     * This list will not contain any duplicate local courses.
     * ObservableList will aid interoperability.
     */
    ObservableList<Note> getNoteList();
}
