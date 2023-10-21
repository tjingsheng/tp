package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.university.University;

/**
 * An UI component that displays information of a {@code University}.
 */
public class UniversityDetail extends UiPart<Region> {

    private static final String FXML = "UniversityDetailCard.fxml";

    public final University university;

    @FXML
    private HBox universityDetailPane;
    @FXML
    private Label universityName;

    /**
     * Creates a {@code UniversityDetail} with the given {@code University}
     */
    public UniversityDetail(University university) {
        super(FXML);
        this.university = university;
        universityName.setText(university.getUniversityName().toString());
    }
}
