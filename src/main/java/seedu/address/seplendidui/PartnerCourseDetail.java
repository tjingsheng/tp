package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * An UI component that displays information of a {@code partnerCourse}.
 */
public class PartnerCourseDetail extends UiPart<Region> {

    private static final String FXML = "PartnerCourseDetailCard.fxml";

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
    @FXML
    private TextFlow partnerDescription;

    /**
     * Creates a {@code partnerCourseDetail} with the given {@code partnerCourse}
     */
    public PartnerCourseDetail(PartnerCourse partnerCourse) {
        super(FXML);
        this.partnerCourse = partnerCourse;
        partnerName.setText(partnerCourse.getPartnerName().toString());
        partnerCode.setText(partnerCourse.getPartnerCode().toString());
        partnerUnit.setText("Units: " + partnerCourse.getPartnerUnit().toString());
        partnerUniversity.setText(partnerCourse.getPartnerUniversity().toString());
        TextFlowHeightUpdater.setAutoFitText(partnerDescription);
        partnerDescription.getChildren().add(new Text(partnerCourse.getPartnerDescription().toString()));
    }
}
