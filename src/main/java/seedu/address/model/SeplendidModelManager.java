package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Filter;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.SeplendidLogsCenter;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.notes.Note;
import seedu.address.model.notes.NoteList;
import seedu.address.model.university.University;

/**
 * Represents the in-memory model of SEPlendid.
 */
public class SeplendidModelManager implements SeplendidModel {
    private static final Logger logger = SeplendidLogsCenter.getLogger(SeplendidModelManager.class);

    // Add all data models here
    private final LocalCourseCatalogue localCourseCatalogue;
    private final UserPrefs userPrefs;
    private final FilteredList<LocalCourse> filteredLocalCourseCatalogue;
    private final UniversityCatalogue universityCatalogue;
    private final FilteredList<University> filteredUniversityCatalogue;
    private final NoteList noteList;

    /**
     * Initializes a SeplendidModelManager with the given localCourseCatalogue, userPrefs,
     * partnerCourseCatalogue, universityCatalogue, mappingCatalogue, noteCatalogue.
     */
    public SeplendidModelManager(ReadOnlyLocalCourseCatalogue localCourseCatalogue, ReadOnlyUserPrefs userPrefs, ReadOnlyUniversityCatalogue universityCatalogue) {
        requireAllNonNull(localCourseCatalogue, userPrefs, universityCatalogue);

        logger.fine("Initializing with local course catalogue: " + localCourseCatalogue
                + " and user prefs " + userPrefs);

        this.localCourseCatalogue = new LocalCourseCatalogue(localCourseCatalogue);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredLocalCourseCatalogue = new FilteredList<>(this.localCourseCatalogue.getLocalCourseList());
        this.noteList = new NoteList();
        this.universityCatalogue = new UniversityCatalogue(universityCatalogue);
        filteredUniversityCatalogue = new FilteredList<>(this.universityCatalogue.getUniversityList());
    }

    public SeplendidModelManager() {
        this(new LocalCourseCatalogue(), new UserPrefs(), new UniversityCatalogue());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getLocalCourseCatalogueFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public Path getUniversityCatalogueFilePath() {
        return userPrefs.getAddressBookFilePath();
    }
    @Override
    public void setLocalCourseCatalogueFilePath(Path localCourseCatalogueFilePath) {
        requireNonNull(localCourseCatalogueFilePath);
        userPrefs.setAddressBookFilePath(localCourseCatalogueFilePath);
    }

    public void setUniversityCatalogueFilePath(Path universityCatalogueFilePath) {
        requireNonNull(universityCatalogueFilePath);
        userPrefs.setAddressBookFilePath(universityCatalogueFilePath);
    }

    //=========== LocalCourseCatalogue ================================================================================

    @Override
    public void setLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) {
        this.localCourseCatalogue.resetData(localCourseCatalogue);
    }

    @Override
    public ReadOnlyLocalCourseCatalogue getLocalCourseCatalogue() {
        return localCourseCatalogue;
    }

    @Override
    public boolean hasLocalCourse(LocalCourse localCourse) {
        requireNonNull(localCourse);
        return localCourseCatalogue.hasLocalCourse(localCourse);
    }

    @Override
    public void deleteLocalCourse(LocalCourse target) {
        localCourseCatalogue.removeLocalCourse(target);
    }

    @Override
    public void addLocalCourse(LocalCourse localCourse) {
        localCourseCatalogue.addLocalCourse(localCourse);
        updateFilteredLocalCourseList(PREDICATE_SHOW_ALL_LOCAL_COURSES);
    }

    @Override
    public void setLocalCourse(LocalCourse target, LocalCourse editedLocalCourse) {
        requireAllNonNull(target, editedLocalCourse);

        localCourseCatalogue.setLocalCourse(target, editedLocalCourse);
    }

    //=========== FilteredLocalCourseList Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code LocalCourse} backed by the internal list of
     * {@code versionedLocalCourseCatalogue}
     */
    @Override
    public ObservableList<LocalCourse> getFilteredLocalCourseList() {
        return filteredLocalCourseCatalogue;
    }

    @Override
    public void updateFilteredLocalCourseList(Predicate<LocalCourse> predicate) {
        requireNonNull(predicate);
        filteredLocalCourseCatalogue.setPredicate(predicate);
    }

    //=========== UniversityCatalogue ================================================================================

    public void setUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue) {
        this.universityCatalogue.resetData(universityCatalogue);
    }

    @Override
    public ReadOnlyUniversityCatalogue getUniversityCatalogue() {
        return universityCatalogue;
    }

    public boolean hasUniversity(University university) {
        requireNonNull(university);
        return universityCatalogue.hasUniversity(university);
    }

//    @Override
//    public void addLocalCourse(LocalCourse localCourse) {
//        localCourseCatalogue.addLocalCourse(localCourse);
//        updateFilteredLocalCourseList(PREDICATE_SHOW_ALL_LOCAL_COURSES);
//    }

//    @Override
//    public void setUniversity(University target, University editedUniversity) {
//        requireAllNonNull(target, editedUniversity);
//
//        universityCatalogue.setUniversities(target, editedUniversity);
//    }
    //=========== FilteredUniversityList Accessors =============================================================

    @Override
    public void updateFilteredUniversityList(Predicate<University> predicate) {
        requireNonNull(predicate);
        filteredUniversityCatalogue.setPredicate(predicate);
    }

    @Override
    public ObservableList<University> getFilteredUniversityList() {
        return filteredUniversityCatalogue;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SeplendidModelManager)) {
            return false;
        }

        SeplendidModelManager otherSeplendidModelManager = (SeplendidModelManager) other;
        return localCourseCatalogue.equals(otherSeplendidModelManager.localCourseCatalogue)
                && userPrefs.equals(otherSeplendidModelManager.userPrefs)
                && filteredLocalCourseCatalogue.equals(otherSeplendidModelManager.filteredLocalCourseCatalogue);
    }

    //=========== NoteCatalouge ================================================================================
    @Override
    public void addNote(Note note) {
        noteList.addNote(note);
    }
}
