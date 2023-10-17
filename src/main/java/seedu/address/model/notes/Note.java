package seedu.address.model.notes;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Note {
    private final String content;
    private final String tags;

    public Note(String content) {
        this.content = content;
        this.tags = "";
    }

    public Note(String content, String tags) {
        this.content = content;
        this.tags = tags;
    }
}
