package seedu.address.seplendidui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.mapping.Mapping;

/**
 * An UI component that displays information of a {@code Mapping}.
 */
public class MappingDetail extends UiPart<Region> {

    private static final String FXML = "MappingDetailCard.fxml";

    public final Mapping mapping;

    @FXML
    private HBox mappingDetailPane;
    @FXML
    private Label title;
    @FXML
    private Label localCode;
    @FXML
    private Label localName;
    @FXML
    private Label localUnit;
    @FXML
    private Label partnerCode;
    @FXML
    private Label partnerName;
    @FXML
    private Label partnerUnit;
    @FXML
    private Label universityName;
    @FXML
    private Label mappingMiscInformation;


    /**
     * Creates a {@code MappingDetail} with the given {@code Mapping}
     */
    public MappingDetail(Mapping mapping,
                         String localNameInput,
                         String localUnitInput,
                         String partnerNameInput,
                         String partnerUnitInput) {
        super(FXML);
        this.mapping = mapping;
        String localCodeInput = mapping.getLocalCode().toString();
        String partnerCodeInput = mapping.getPartnerCode().toString();
        title.setText(localCodeInput + " maps to " + partnerCodeInput);
        localCode.setText(localCodeInput);
        localName.setText(localNameInput);
        localUnit.setText("Units: " + localUnitInput);
        partnerCode.setText(partnerCodeInput);
        partnerName.setText(partnerNameInput);
        partnerUnit.setText("Units: " + partnerUnitInput);
        universityName.setText(mapping.getUniversityName().toString());
        mappingMiscInformation.setText(mapping.getMappingMiscInformation().toString());
    }
}
