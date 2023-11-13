package seedu.address.logic.commands.mapping;

import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandSuccess;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_COURSE;
import static seedu.address.testutil.TypicalObjects.TYPICAL_PARTNER_UNIVERSITY_NAME;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalMappingCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalMappings;
import static seedu.address.testutil.TypicalObjects.getTypicalNoteCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.messages.Messages;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.mapping.Mapping;

//@@author lamchenghou

/**
 * Contains integration tests (interaction with the SeplendidModel) for {@code MappingDeleteCommand}.
 */
public class MappingDeleteCommandIntegrationTest {

    private SeplendidModel model;

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(new UserPrefs(),
                getTypicalLocalCourseCatalogue(),
                getTypicalPartnerCourseCatalogue(),
                getTypicalUniversityCatalogue(),
                getTypicalMappingCatalogue(),
                getTypicalNoteCatalogue());
    }

    @Test
    public void execute_deleteMapping_success() {
        Mapping validExistingMapping = getTypicalMappings().get(0);

        SeplendidModel expectedModel = new SeplendidModelManager(new UserPrefs(),
                model.getLocalCourseCatalogue(),
                model.getPartnerCourseCatalogue(),
                model.getUniversityCatalogue(),
                getTypicalMappingCatalogue(),
                model.getNoteCatalogue());
        expectedModel.deleteMapping(validExistingMapping);

        assertSeplendidCommandSuccess(new MappingDeleteCommand(validExistingMapping.getLocalCode(),
                        validExistingMapping.getUniversityName(), validExistingMapping.getPartnerCode()),
                model,
                String.format(
                        MappingDeleteCommand.MESSAGE_SUCCESS,
                        Messages.format(validExistingMapping)),
                expectedModel);
    }

    @Test
    public void execute_nonExistingMapping_throwsCommandException() {
        assertSeplendidCommandFailure(new MappingDeleteCommand(TYPICAL_LOCAL_COURSE.getLocalCode(),
                        TYPICAL_PARTNER_UNIVERSITY_NAME, TYPICAL_PARTNER_COURSE.getPartnerCode()),
                model,
                MappingDeleteCommand.MESSAGE_NONEXISTENT_MAPPING);
    }

}
