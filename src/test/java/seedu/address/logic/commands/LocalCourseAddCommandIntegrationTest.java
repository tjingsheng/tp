package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandSuccess;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.testutil.LocalCourseBuilder;

/**
 * Contains integration tests (interaction with the SeplendidModel) for {@code LocalCourseAddCommand}.
 */
public class LocalCourseAddCommandIntegrationTest {

    private SeplendidModel model;

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(getTypicalLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue());
    }

    @Test
    public void execute_newLocalCourse_success() {
        LocalCourse validLocalCourse = new LocalCourseBuilder().build();

        SeplendidModel expectedModel = new SeplendidModelManager(model.getLocalCourseCatalogue(), new UserPrefs(),
                model.getPartnerCourseCatalogue(), model.getUniversityCatalogue());
        expectedModel.addLocalCourse(validLocalCourse);

        assertSeplendidCommandSuccess(new LocalCourseAddCommand(validLocalCourse), model,
                String.format(LocalCourseAddCommand.MESSAGE_SUCCESS, Messages.format(validLocalCourse)),
                expectedModel);
    }

    @Test
    public void execute_duplicateLocalCourse_throwsCommandException() {
        LocalCourse localCourseInList = model.getLocalCourseCatalogue().getLocalCourseList().get(0);
        assertSeplendidCommandFailure(new LocalCourseAddCommand(localCourseInList), model,
                LocalCourseAddCommand.MESSAGE_DUPLICATE_LOCAL_COURSE);
    }

}
