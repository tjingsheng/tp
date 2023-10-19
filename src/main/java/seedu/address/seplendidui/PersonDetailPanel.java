package seedu.address.seplendidui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the details of a person.
 */
public class PersonDetailPanel extends UiPart<Region> {
    private static final String FXML = "PersonDetailPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Person> personDetailView;

    /**
     * Creates a {@code PersonDetailPanel}.
     */
    public PersonDetailPanel() {
        super(FXML);
        // Set the cell factory to display PersonCard in the ListView
        personDetailView.setCellFactory(listView -> new PersonDetailListViewCell());
    }

    /**
     * Set the details of the selected person.
     * @param person The selected person
     */
    public void setPersonDetails(Person person) {
        // Clear the existing items and add the selected person
        personDetailView.getItems().clear();
        if (person != null) {
            personDetailView.getItems().add(person);
        }
    }

    /**
     * Custom {@code ListCell} that displays the details of a {@code Person}.
     */
    class PersonDetailListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonDetail(person, 1).getRoot());
            }
        }
    }
}
