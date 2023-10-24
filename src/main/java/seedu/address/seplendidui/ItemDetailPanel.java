package seedu.address.seplendidui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.university.University;

/**
 * Panel containing the details of an item.
 */
public class ItemDetailPanel<SeplendidDataType> extends UiPart<Region> {
    private static final String FXML = "ItemDetailPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ItemDetailPanel.class);
    @FXML
    private VBox itemDetailView;

    /**
     * Creates a {@code ItemDetailPanel}.
     */
    public ItemDetailPanel() {
        super(FXML);
    }

    /**
     * Set the details of the selected item.
     *
     * @param item The selected item
     */
    public void setItemDetail(SeplendidDataType item) {
        // Directly set the item to the container
        if (item != null) {
            if (item instanceof LocalCourse) {
                itemDetailView.getChildren().setAll(new LocalCourseDetail((LocalCourse) item).getRoot());
            } else if (item instanceof PartnerCourse) {
                itemDetailView.getChildren().setAll(new PartnerCourseDetail((PartnerCourse) item).getRoot());
            } else if (item instanceof University) {
                itemDetailView.getChildren().setAll(new UniversityDetail((University) item).getRoot());
            }
        }
    }
}
