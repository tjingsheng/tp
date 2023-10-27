package seedu.address.seplendidui;

import java.util.Optional;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.SeplendidLogic;
import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.university.University;

/**
 * Panel containing the details of an item.
 */
public class ItemDetailPanel<SeplendidDataType> extends UiPart<Region> {

    private static final String MESSAGE_MAPPING_ITEM_DETAIL_PANEL_ERROR = "Error with mapping item detail panel.";
    private static final String FXML = "ItemDetailPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ItemDetailPanel.class);
    @FXML
    private ListView<SeplendidDataType> itemDetailView;

    // For access to catalogues
    private SeplendidLogic seplendidLogic;

    /**
     * Creates a {@code ItemDetailPanel}.
     */
    public ItemDetailPanel(SeplendidLogic logic) {
        super(FXML);
        // Set the cell factory to display item in the ListView
        itemDetailView.setCellFactory(listView -> new ItemDetailViewCell());
        seplendidLogic = logic;
    }

    /**
     * Set the details of the selected item.
     *
     * @param item The selected item
     */
    public void setItemDetail(SeplendidDataType item) {
        // Clear the existing items and add the selected item
        itemDetailView.getItems().clear();
        if (item != null) {
            itemDetailView.getItems().add(item);
        }
    }

    //TODO: Convert it to single item instead of list, detail panel should always be a single item.

    /**
     * Custom {@code ListCell} that displays the details of an {@code Item}.
     */
    class ItemDetailViewCell extends ListCell<SeplendidDataType> {
        @Override
        protected void updateItem(SeplendidDataType item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setGraphic(null);
                setText(null);
            } else if (item instanceof LocalCourse) {
                setGraphic(new LocalCourseDetail((LocalCourse) item).getRoot());
            } else if (item instanceof PartnerCourse) {
                setGraphic(new PartnerCourseDetail((PartnerCourse) item).getRoot());
            } else if (item instanceof University) {
                setGraphic(new UniversityDetail((University) item).getRoot());
            } else if (item instanceof Mapping) {
                Mapping mapping = (Mapping) item;
                // We know that RTT of getLocalCourseCatalogue() is LocalCourseCatalogue.
                LocalCourseCatalogue localCourseCatalogue =
                        (LocalCourseCatalogue) seplendidLogic.getLocalCourseCatalogue();
                Optional<LocalCourse> localCourse = localCourseCatalogue.getLocalCourseIfExists(mapping.getLocalCode());
                // We know that RTT of getPartnerCourseCatalogue() is PartnerCourseCatalogue.
                PartnerCourseCatalogue partnerCourseCatalogue =
                        (PartnerCourseCatalogue) seplendidLogic.getPartnerCourseCatalogue();
                Optional<PartnerCourse> partnerCourse =
                        partnerCourseCatalogue.getPartnerCourseIfExists(
                                                mapping.getPartnerCode(), mapping.getUniversityName());
                if (localCourse.isPresent() && partnerCourse.isPresent()) {
                    setGraphic(new MappingDetail(mapping,
                            localCourse.get().getLocalName().getValue(),
                            localCourse.get().getLocalUnit().toString(),
                            partnerCourse.get().getPartnerName().toString(),
                            partnerCourse.get().getPartnerUnit().toString()).getRoot());
                } else {
                    logger.warning(MESSAGE_MAPPING_ITEM_DETAIL_PANEL_ERROR);
                }
            }
        }
    }
}
