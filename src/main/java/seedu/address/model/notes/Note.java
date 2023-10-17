package seedu.address.model.notes;

/**
 * Represents a note in SEPlendid
 */
public class Note {
    private final String content;
    private final String tags;

    /**
     * Constructs an {@code Note}.
     *
     * @param content A String of content.
     */
    public Note(String content) {
        this.content = content;
        this.tags = "";
    }

    /**
     * Constructs an {@code Note}.
     *
     * @param content A String of content.
     * @param tags A string of tags.
     */
    public Note(String content, String tags) {
        this.content = content;
        this.tags = tags;
    }

    /**
     * Gets the tags of the note.
     */
    public String getTags() {
        return tags;
    }

    /**
     * Gets the content of the note.
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content + "\n tags: " + tags;
    }
}
