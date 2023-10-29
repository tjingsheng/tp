package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import org.w3c.dom.Text;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * A UI component that displays information of a {@code note}.
 */
public class NoteDetail extends UiPart<Region> {

    private static final String FXML = "noteDetailCard.fxml";

    public final Note note;

    @FXML
    private HBox noteDetailPane;
    @FXML
    private Label tags;
    @FXML
    private TextArea content;

    /**
     * Creates a {@code noteDetail} with the given {@code note}
     */
    public NoteDetail(Note note) {
        super(FXML);
        this.note = note;
        content.setText(note.getContent().toString());
        tags.setText("Tags:" + note.getTags().toString());
    }
}
