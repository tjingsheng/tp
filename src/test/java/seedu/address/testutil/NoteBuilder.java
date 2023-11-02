package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.note.Content;
import seedu.address.model.note.Note;
import seedu.address.model.tag.Tag;

/**
 * A builder class for creating instances of the Note class.
 */
public class NoteBuilder {
    private Content content;
    private Set<Tag> tags = new HashSet<>();
    private Integer index;

    public NoteBuilder withContent(String content) {
        this.content = new Content(content);
        return this;
    }

    public NoteBuilder withTag(Tag tag) {
        this.tags.add(tag);
        return this;
    }

    public NoteBuilder withTags(Set<Tag> tags) {
        this.tags.addAll(tags);
        return this;
    }

    public NoteBuilder withIndex(Integer index) {
        this.index = index;
        return this;
    }

    public Note build() {
        Note note;
        if (index != null) {
            note = new Note(content, tags, index);
        } else {
            note = new Note(content, tags);
        }
        return note;
    }
}
