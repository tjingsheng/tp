package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandSuccess;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourses;
import static seedu.address.testutil.TypicalObjects.getTypicalNoteCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.localcourse.LocalCourse;

/**
 * Contains integration tests (interaction with the SeplendidModel) for {@code LocalCourseDeleteCommand}.
 */
public class LocalCourseDeleteCommandIntegrationTest {

    private SeplendidModel model;

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(getTypicalLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue(), getTypicalNoteCatalogue());
    }

    @Test
    public void execute_deleteLocalCourse_success() {
        LocalCourse validExistingLocalCourse = getTypicalLocalCourses().get(0);

        SeplendidModel expectedModel = new SeplendidModelManager(model.getLocalCourseCatalogue(), new UserPrefs(),
                model.getPartnerCourseCatalogue(), model.getUniversityCatalogue(), model.getNoteCatalogue());
        expectedModel.deleteLocalCourse(validExistingLocalCourse);

        assertSeplendidCommandSuccess(new LocalCourseDeleteCommand(validExistingLocalCourse.getLocalCode()), model,
                String.format(LocalCourseDeleteCommand.MESSAGE_SUCCESS, Messages.format(validExistingLocalCourse)),
                expectedModel);
    }

    @Test
    public void execute_nonExistingeLocalCourse_throwsCommandException() {
        assertSeplendidCommandFailure(new LocalCourseDeleteCommand(TYPICAL_LOCAL_COURSE.getLocalCode()), model,
                LocalCourseDeleteCommand.MESSAGE_NONEXISTENT_LOCAL_COURSE);
    }

}
