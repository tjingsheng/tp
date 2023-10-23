package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * An UI component that displays information of a {@code partnerCourse}.
 */
public class PartnerCourseDetail extends UiPart<Region> {

    private static final String FXML = "partnerCourseDetailCard.fxml";

    public final PartnerCourse partnerCourse;

    @FXML
    private HBox partnerCourseDetailPane;
    @FXML
    private Label partnerName;
    @FXML
    private Label partnerCode;
    @FXML
    private Label partnerUnit;
    @FXML
    private Label partnerUniversity;

    /**
     * Creates a {@code partnerCourseDetail} with the given {@code partnerCourse}
     */
    public PartnerCourseDetail(PartnerCourse partnerCourse) {
        super(FXML);
        this.partnerCourse = partnerCourse;
        partnerName.setText(partnerCourse.getPartnerName().toString());
        partnerCode.setText(partnerCourse.getPartnerCode().toString());
        partnerUnit.setText(partnerCourse.getPartnerUnit().toString());
        partnerUniversity.setText(partnerCourse.getPartnerUniversity().getUniversityName().toString());
    }
}
