package seedu.address.model.sampledata;

import seedu.address.model.notes.Content;
import seedu.address.model.notes.Note;
import seedu.address.model.tag.Tag;

/**
 * A utility class that provides sample notes for seeding the application.
 */
public class SampleNotes {
    /**
     * Returns an array of sample notes
     *
     * @return An array of sample {@code Note} objects.
     */
    public static Note[] getSampleNotes() {
        return new Note[] {new Note(new Content("Dummy Note 1"),
            new Tag("dummy")),
            new Note(new Content("Dummy Note 2"), new Tag("dummy"))
        };
    }
}
