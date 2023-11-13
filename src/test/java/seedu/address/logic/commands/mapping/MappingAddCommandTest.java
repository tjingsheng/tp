package seedu.address.logic.commands.mapping;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalObjects.CS2030S_TO_ZURICH_COMP3000;
import static seedu.address.testutil.TypicalObjects.CS2040S_TO_NTU_S0402SC;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.SeplendidModelStub;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.messages.Messages;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.university.UniversityName;
import seedu.address.testutil.MappingBuilder;

//@@author lamchenghou

/**
 * Unit testing of MappingAddCommand, with stubs / dependency injection.
 */
public class MappingAddCommandTest {

    @Test
    public void constructor_nullMapping_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MappingAddCommand(null));
    }

    @Test
    public void execute_mappingAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingMappingAdded modelStub = new ModelStubAcceptingMappingAdded();
        Mapping validMapping = new MappingBuilder().build();
        // Tests interactions with model
        CommandResult commandResult = new MappingAddCommand(validMapping).execute(modelStub);

        assertEquals(
                String.format(MappingAddCommand.MESSAGE_SUCCESS, Messages.format(validMapping)),
                commandResult.getFeedbackToUser());
        assertEquals(List.of(validMapping), modelStub.mappingsAdded);
    }

    @Test
    public void execute_duplicateMapping_throwsCommandException() {
        Mapping validMapping = new MappingBuilder().build();
        MappingAddCommand mappingAddCommand = new MappingAddCommand(validMapping);
        SeplendidModelStub modelStub = new SeplendidModelStubWithMapping(validMapping);

        assertThrows(CommandException.class,
                MappingAddCommand.MESSAGE_DUPLICATE_MAPPING, () -> mappingAddCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        MappingAddCommand addCs2030sMappingCommand = new MappingAddCommand(CS2030S_TO_ZURICH_COMP3000);
        MappingAddCommand addCs2040sMappingCommand = new MappingAddCommand(CS2040S_TO_NTU_S0402SC);

        // same object -> returns true
        assertTrue(addCs2030sMappingCommand.equals(addCs2030sMappingCommand));

        // same values -> returns true
        MappingAddCommand addCs2030sMappingCommandCopy = new MappingAddCommand(CS2030S_TO_ZURICH_COMP3000);
        assertTrue(addCs2030sMappingCommand.equals(addCs2030sMappingCommandCopy));

        // different types -> returns false
        assertFalse(addCs2030sMappingCommand.equals(1));

        // null -> returns false
        assertFalse(addCs2030sMappingCommand.equals(null));

        // different mappings -> returns false
        assertFalse(addCs2030sMappingCommand.equals(addCs2040sMappingCommand));
    }

    @Test
    public void toStringMethod() {
        MappingAddCommand mappingAddCommand = new MappingAddCommand(CS2030S_TO_ZURICH_COMP3000);
        String expected = MappingAddCommand.class.getCanonicalName()
                + "{mappingToAdd=" + CS2030S_TO_ZURICH_COMP3000 + "}";
        assertEquals(expected, mappingAddCommand.toString());
    }

    /**
     * A Model stub that contains a single mapping.
     */
    private class SeplendidModelStubWithMapping extends SeplendidModelStub {
        private final Mapping mapping;

        SeplendidModelStubWithMapping(Mapping m) {
            requireNonNull(m);
            mapping = m;
        }

        @Override
        public boolean hasMapping(Mapping m) {
            requireNonNull(m);
            return mapping.isSameMapping(m);
        }
    }

    /**
     * A Model stub that always accept the mapping being added.
     */
    private class ModelStubAcceptingMappingAdded extends SeplendidModelStub {
        final ArrayList<Mapping> mappingsAdded = new ArrayList<>();

        @Override
        public boolean hasMapping(Mapping mapping) {
            requireNonNull(mapping);
            return mappingsAdded.stream().anyMatch(mapping::isSameMapping);
        }

        @Override
        public void addMapping(Mapping mapping) {
            requireNonNull(mapping);
            mappingsAdded.add(mapping);
        }

        @Override
        public boolean hasLocalCourse(LocalCode localCode) {
            return true;
        }

        @Override
        public boolean hasPartnerCourse(PartnerCode partnerCode, UniversityName universityName) {
            return true;
        }

        @Override
        public boolean hasUniversity(UniversityName universityName) {
            return true;
        }
    }

}
