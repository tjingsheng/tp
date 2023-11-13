package seedu.address.logic.commands.localcourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandSuccess;
import static seedu.address.testutil.TypicalObjects.CS2042S;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalMappingCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalNoteCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.messages.Messages;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyMappingCatalogue;
import seedu.address.model.ReadOnlyNoteCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalCourseContainsKeywordsPredicate;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.note.Note;
import seedu.address.model.note.NoteTagContainsKeywordsPredicate;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerCourseContainsKeywordsPredicate;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;
import seedu.address.model.university.UniversityNameContainsKeywordsPredicate;
import seedu.address.testutil.LocalCourseBuilder;

public class LocalCourseSearchCommandTest {
    private SeplendidModel model;
    private SeplendidModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(new UserPrefs(), getTypicalLocalCourseCatalogue(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue(),
                getTypicalMappingCatalogue(), getTypicalNoteCatalogue());
        expectedModel = new SeplendidModelManager(new UserPrefs(), model.getLocalCourseCatalogue(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue(),
                getTypicalMappingCatalogue(), getTypicalNoteCatalogue());
        model.addLocalCourse(CS2042S);
        expectedModel.addLocalCourse(CS2042S);
    }

    @Test
    public void execute_validLocalCode_success() throws CommandException {
        LocalCourse courseToSearch = new LocalCourseBuilder().withLocalCode("CS2042S").build();

        LocalCourseSearchCommand searchCommand = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALCODE,
                new LocalCourseContainsKeywordsPredicate("CS2042S", LocalCourseAttribute.LOCALCODE),
                "2042S"
        );

        searchCommand.execute(model);

        expectedModel.searchLocalCourses(LocalCourseAttribute.LOCALCODE,
                new LocalCourseContainsKeywordsPredicate("CS2042S", LocalCourseAttribute.LOCALCODE));

        assertSeplendidCommandSuccess(searchCommand,
                model,
                String.format(LocalCourseSearchCommand.MESSAGE_SUCCESS,
                        Messages.format(model.getFilteredLocalCourseList())),
                expectedModel);
    }

    @Test
    public void execute_validLocalName_success() throws CommandException {
        LocalCourse courseToSearch = new LocalCourseBuilder().withLocalName("Data Structures & Algorithms").build();

        LocalCourseSearchCommand searchCommand = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALNAME,
                new LocalCourseContainsKeywordsPredicate("Data Structures & Algorithms",
                        LocalCourseAttribute.LOCALNAME),
                "Data Structures"
        );

        searchCommand.execute(model);

        expectedModel.searchLocalCourses(LocalCourseAttribute.LOCALNAME,
                new LocalCourseContainsKeywordsPredicate("Data Structures & Algorithms",
                        LocalCourseAttribute.LOCALNAME));

        assertSeplendidCommandSuccess(searchCommand,
                model,
                String.format(LocalCourseSearchCommand.MESSAGE_SUCCESS,
                        Messages.format(model.getFilteredLocalCourseList())),
                expectedModel);
    }

    @Test
    public void execute_validLocalUnit_success() throws CommandException {
        LocalCourse courseToSearch = new LocalCourseBuilder().withLocalName("4.0").build();

        LocalCourseSearchCommand searchCommand = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALUNIT,
                new LocalCourseContainsKeywordsPredicate("4.0",
                        LocalCourseAttribute.LOCALUNIT),
                "4"
        );

        searchCommand.execute(model);

        expectedModel.searchLocalCourses(LocalCourseAttribute.LOCALUNIT,
                new LocalCourseContainsKeywordsPredicate("4.0",
                        LocalCourseAttribute.LOCALUNIT));

        assertSeplendidCommandSuccess(searchCommand,
                model,
                String.format(LocalCourseSearchCommand.MESSAGE_SUCCESS,
                        Messages.format(model.getFilteredLocalCourseList())),
                expectedModel);
    }

    @Test
    public void execute_validLocalDescription_success() throws CommandException {
        LocalCourse courseToSearch = new LocalCourseBuilder().withLocalDescription(
                "This course introduces students to the "
                + "design and implementation of "
                + "fundamental data structures and "
                + "algorithms. The course covers basic "
                + "data structures (linked lists, "
                + "stacks, queues, hash tables, binary "
                + "heaps, trees, and graphs), searching"
                + " and sorting algorithms, and basic "
                + "analysis of algorithms.").build();

        LocalCourseSearchCommand searchCommand = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALNAME,
                new LocalCourseContainsKeywordsPredicate(
                        "This course introduces students to the "
                        + "design and implementation of "
                        + "fundamental data structures and "
                        + "algorithms. The course covers basic "
                        + "data structures (linked lists, "
                        + "stacks, queues, hash tables, binary "
                        + "heaps, trees, and graphs), searching"
                        + " and sorting algorithms, and basic "
                        + "analysis of algorithms.",
                        LocalCourseAttribute.LOCALNAME),
                "This course introduces students to the "
                        + "design and implementation of "
                        + "fundamental data structures and "
                        + "algorithms. The course covers basic "
                        + "data structures (linked lists, "
                        + "stacks, queues, hash tables, binary "
                        + "heaps, trees, and graphs), searching"
                        + " and sorting algorithms, and basic "
                        + "analysis."
        );

        searchCommand.execute(model);

        expectedModel.searchLocalCourses(LocalCourseAttribute.LOCALNAME,
                new LocalCourseContainsKeywordsPredicate(
                        "This course introduces students to the "
                        + "design and implementation of "
                        + "fundamental data structures and "
                        + "algorithms. The course covers basic "
                        + "data structures (linked lists, "
                        + "stacks, queues, hash tables, binary "
                        + "heaps, trees, and graphs), searching"
                        + " and sorting algorithms, and basic "
                        + "analysis of algorithms.",
                        LocalCourseAttribute.LOCALNAME));

        assertSeplendidCommandSuccess(searchCommand,
                model,
                String.format(LocalCourseSearchCommand.MESSAGE_SUCCESS,
                        Messages.format(model.getFilteredLocalCourseList())),
                expectedModel);
    }

    @Test
    public void equals() {
        LocalCourseContainsKeywordsPredicate firstPredicate = new LocalCourseContainsKeywordsPredicate(
                "CS2042S",
                LocalCourseAttribute.LOCALCODE);
        LocalCourseContainsKeywordsPredicate secondPredicate = new LocalCourseContainsKeywordsPredicate(
                "CS2041S",
                LocalCourseAttribute.LOCALCODE);
        LocalCourseSearchCommand searchCommandWithFirstPredicate = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALCODE, firstPredicate, "CS2042S");
        LocalCourseSearchCommand searchCommandWithSecondPredicate = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALCODE, secondPredicate, "CS2041S");

        // same object -> returns true
        assertTrue(
                searchCommandWithFirstPredicate.equals(searchCommandWithFirstPredicate));

        // same values -> returns true
        LocalCourseSearchCommand searchCommandWithFirstPredicateCopy = new LocalCourseSearchCommand(
                LocalCourseAttribute.LOCALCODE, firstPredicate, "CS2042S");
        assertTrue(searchCommandWithFirstPredicate.equals(searchCommandWithFirstPredicateCopy));

        // different types -> returns false
        assertFalse(searchCommandWithFirstPredicate.equals(1));

        // null -> returns false
        assertFalse(searchCommandWithFirstPredicate.equals(null));

        // different note -> returns false
        assertFalse(searchCommandWithFirstPredicate.equals(searchCommandWithSecondPredicate));
    }

    /**
     * A default model stub that have all methods failing.
     */
    private class SeplendidModelStub implements SeplendidModel {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        // LocalCourse
        @Override
        public void searchLocalCourses(LocalCourseAttribute attribute,
                                       LocalCourseContainsKeywordsPredicate predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getLocalCourseCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLocalCourseCatalogueFilePath(Path localCourseCatalogueFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addLocalCourse(LocalCourse localCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyLocalCourseCatalogue getLocalCourseCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasLocalCourse(LocalCourse localCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasLocalCourse(LocalCode localCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<LocalCourse> getLocalCourseIfExists(LocalCode localCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteLocalCourse(LocalCourse localCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setLocalCourse(LocalCourse localCourse, LocalCourse editedLocalCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<LocalCourse> getSortedLocalCourseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateSortedLocalList(Comparator<LocalCourse> localCourseComparator) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<LocalCourse> getFilteredLocalCourseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredLocalCourseList(Predicate<LocalCourse> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        // PartnerCourse
        @Override
        public void searchPartnerCourses(PartnerCourseAttribute attribute,
                                         PartnerCourseContainsKeywordsPredicate predicate) {
        }

        @Override
        public Path getPartnerCourseCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPartnerCourseCatalogueFilePath(Path partnerCourseCatalogueFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPartnerCourse(PartnerCourse partnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPartnerCourse(PartnerCourse target, PartnerCourse editedPartnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePartnerCourse(PartnerCourse partnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<PartnerCourse> getSortedPartnerCourseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateSortedPartnerList(Comparator<PartnerCourse> partnerCourseComparator) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyPartnerCourseCatalogue getPartnerCourseCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPartnerCourse(PartnerCourse partnerCourse) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPartnerCourse(PartnerCode partnerCode, UniversityName universityName) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<PartnerCourse> getPartnerCourseIfExists(
                PartnerCode partnerCode, UniversityName universityName) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<PartnerCourse> getFilteredPartnerCourseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPartnerCourseList(Predicate<PartnerCourse> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        // University
        @Override
        public Path getUniversityCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUniversityCatalogue getUniversityCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void getSearchUniversityIfExists(
                UniversityNameContainsKeywordsPredicate universityNameContainsKeywordsPredicate
        ) {
        }

        public Optional<University> getUniversityIfExists(UniversityName universityName) {

            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setNoteCatalogue(ReadOnlyNoteCatalogue noteCatalogue) {

        }

        @Override
        public ReadOnlyNoteCatalogue getNoteCatalogue() {
            return null;
        }

        @Override
        public boolean hasNote(Note note) {
            return false;
        }

        @Override
        public Note deleteNote(int noteIndex) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUniversityCatalogueFilePath(Path universityCatalogueFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<University> getFilteredUniversityList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasUniversity(University university) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasUniversity(UniversityName universityName) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addUniversity(University university) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUniversity(University target, University editedUniversity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<University> getSortedUniversityList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateSortedUniversityList(Comparator<University> universityComparator) {
            throw new AssertionError("This method should not be called.");
        }


        @Override
        public void updateFilteredUniversityList(Predicate<University> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue) {
            throw new AssertionError("This method should not be called.");
        }

        // Note
        @Override
        public void addNote(Note note) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setNote(Note note, Note editedNote) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void getSearchNoteIfExists(NoteTagContainsKeywordsPredicate notePredicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Note> getFilteredNoteList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredNoteList(Predicate<Note> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getMappingCatalogueFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMappingCatalogue(ReadOnlyMappingCatalogue mappingCatalogue) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyMappingCatalogue getMappingCatalogue() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMapping(Mapping mapping) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMapping(LocalCode localCode, UniversityName universityName, PartnerCode partnerCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Optional<Mapping> getMappingIfExists(LocalCode localCode, UniversityName universityName,
                                                    PartnerCode partnerCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMappingWithLocalCode(LocalCode localCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMappingWithPartnerCode(PartnerCode partnerCode) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteMapping(Mapping mapping) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addMapping(Mapping mapping) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMapping(Mapping mapping, Mapping editedMapping) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Mapping> getFilteredMappingList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredMappingList(Predicate<Mapping> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Mapping> getSortedMappingList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateSortedMappingList(Comparator<Mapping> mappingComparator) {
            throw new AssertionError("This method should not be called.");
        }

    }




}
