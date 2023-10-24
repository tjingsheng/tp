package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.partnercourse.PartnerName;

/**
 * An UI component that displays information of a {@code Mapping}.
 */
public class MappingDetail extends UiPart<Region> {

    private static final String FXML = "MappingDetailCard.fxml";

    public final Mapping mapping;

    @FXML
    private HBox mappingDetailPane;
    @FXML
    private Label localCode;
    @FXML
    private Label localName;
    @FXML
    private Label universityName;
    @FXML
    private Label partnerCode;
    @FXML
    private Label partnerName;
    @FXML
    private Label mappingMiscInformation;


    /**
     * Creates a {@code MappingDetail} with the given {@code Mapping}
     */
    public MappingDetail(Mapping mapping, LocalName localNameInput, PartnerName partnerNameInput) {
        super(FXML);
        this.mapping = mapping;
        localCode.setText(mapping.getLocalCode().toString());
        localName.setText(localNameInput.toString());
        universityName.setText(mapping.getUniversityName().toString());
        partnerCode.setText(mapping.getPartnerCode().toString());
        partnerName.setText(partnerNameInput.toString());
        mappingMiscInformation.setText(mapping.getMappingMiscInformation().toString());
    }
}
