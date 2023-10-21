package seedu.address.seplendidui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

/**
 * The UI component that is responsible for returning the feedback of the application to the user.
 */
public class ResultBox extends UiPart<Region> {

    private static final String FXML = "ResultBox.fxml";

    @FXML
    private TextField resultTextField;

    public ResultBox() {
        super(FXML);
    }

    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        resultTextField.setText(feedbackToUser);
    }
}
