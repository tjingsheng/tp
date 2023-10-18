package seedu.address.model.notes;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a note in SEPlendid
 */
public class Note {
    private final Content content;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Constructs an {@code Note}.
     * Every field must be present and not null.
     * @param content Content for the Note
     * @param tags Tags for the note
     */
    public Note(Content content, Tag tags) {
        requireAllNonNull(content, tags);
        this.content = content;
        this.tags.add(tags);
    }

    /**
     * Gets the tags of the note.
     */
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * Gets the content of the note.
     */
    public Content getContent() {
        return content;
    }

    /**
     * Returns true if both notes have the same content.
     * This defines a weaker notion of equality between two notes.
     */
    public boolean isSameNote(Note otherNote) {
        if (otherNote == this) {
            return true;
        }

        return otherNote != null
                && otherNote.getContent().equals(getContent());
    }

    /**
     * Returns true if both notes have the same identity and data fields.
     * This defines a stronger notion of equality between two notes.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Note)) {
            return false;
        }

        Note otherNote = (Note) other;
        return content.equals(otherNote.content)
                && tags.equals(otherNote.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(content, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("content", content)
                .add("tags", tags)
                .toString();
    }
}
