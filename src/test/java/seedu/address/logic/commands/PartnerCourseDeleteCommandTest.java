package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandSuccess;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalNoteCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourses;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code PartnerCourseDeleteCommandTest}.
 */
public class PartnerCourseDeleteCommandTest {
    private SeplendidModel model;
    private SeplendidModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(getTypicalLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue(), getTypicalNoteCatalogue());
    }

    @Test
    public void execute_partnerCourseDelete_success() {
        PartnerCourse partnerCourseToDelete = getTypicalPartnerCourses().get(0);
        SeplendidModel expectedModel = new SeplendidModelManager(model.getLocalCourseCatalogue(), new UserPrefs(),
                model.getPartnerCourseCatalogue(), model.getUniversityCatalogue(), model.getNoteCatalogue());

        expectedModel.deletePartnerCourse(partnerCourseToDelete);

        assertSeplendidCommandSuccess(new PartnerCourseDeleteCommand(partnerCourseToDelete.getPartnerCode()), model,
                String.format(PartnerCourseDeleteCommand.MESSAGE_SUCCESS, Messages.format(partnerCourseToDelete)),
                expectedModel);
    }

    //more to be added.

}
