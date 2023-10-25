package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.localcourse.LocalCourse;

/**
 * An UI component that displays information of a {@code LocalCourse}.
 */
public class LocalCourseDetail extends UiPart<Region> {

    private static final String FXML = "LocalCourseDetailCard.fxml";

    public final LocalCourse localCourse;

    @FXML
    private HBox localCourseDetailPane;
    @FXML
    private Label localName;
    @FXML
    private Label localCode;
    @FXML
    private Label localUnit;

    /**
     * Creates a {@code LocalCourseDetail} with the given {@code LocalCourse}
     */
    public LocalCourseDetail(LocalCourse localCourse) {
        super(FXML);
        this.localCourse = localCourse;
        localName.setText(localCourse.getLocalName().toString());
        localCode.setText(localCourse.getLocalCode().toString());
        localUnit.setText("Units: " +localCourse.getLocalUnit().toString());
    }
}
