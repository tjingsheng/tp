package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.SeplendidModel.PREDICATE_SHOW_ALL_LOCAL_COURSES;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalObjects.COMP1000;
import static seedu.address.testutil.TypicalObjects.COMP2000;
import static seedu.address.testutil.TypicalObjects.CS2030S;
import static seedu.address.testutil.TypicalObjects.CS2040S;
import static seedu.address.testutil.TypicalObjects.CS3230;
import static seedu.address.testutil.TypicalObjects.MA2001;
import static seedu.address.testutil.TypicalObjects.getTypicalNoteCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;
import seedu.address.testutil.LocalCourseCatalogueBuilder;
import seedu.address.testutil.PartnerCourseCatalogueBuilder;

public class SeplendidModelManagerTest {

    private SeplendidModelManager modelManager = new SeplendidModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new LocalCourseCatalogue(), new LocalCourseCatalogue(modelManager.getLocalCourseCatalogue()));
        // Developers note: Add for appropriate catalogues
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        // TBD: remove when morph is done
        userPrefs.setAddressBookFilePath(Paths.get("address/book/file/path"));
        userPrefs.setLocalCourseCatalogueFilePath(Paths.get("local/course/catalogue/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setAddressBookFilePath(Paths.get("new/address/book/file/path"));
        userPrefs.setLocalCourseCatalogueFilePath(Paths.get("local/course/catalogue/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setLocalCourseCatalogueFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setLocalCourseCatalogueFilePath(null));
    }

    @Test
    public void setLocalCourseCatalogueFilePath_validPath_setsLocalCourseCatalogueFilePath() {
        Path path = Paths.get("local/course/catalogue/file/path");
        modelManager.setLocalCourseCatalogueFilePath(path);
        assertEquals(path, modelManager.getLocalCourseCatalogueFilePath());
    }

    @Test
    public void hasLocalCourse_nullLocalCourse_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasLocalCourse(null));
    }

    @Test
    public void hasLocalCourse_localCourseNotInLocalCourseCatalogue_returnsFalse() {
        assertFalse(modelManager.hasLocalCourse(CS3230));
    }

    @Test
    public void hasLocalCourse_localCourseInLocalCourseCatalogue_returnsTrue() {
        modelManager.addLocalCourse(CS3230);
        assertTrue(modelManager.hasLocalCourse(CS3230));
    }

    @Test
    public void getLocalCourseIfExists_localCourseInLocalCourseCatalogue_returnsLocalCourse() {
        modelManager.addLocalCourse(MA2001);
        assertEquals(MA2001, modelManager.getLocalCourseIfExists(MA2001.getLocalCode()).get());
    }

    @Test
    public void getLocalCourseIfExists_localCourseNotInLocalCourseCatalogue_returnsEmpty() {
        assertEquals(Optional.empty(), modelManager.getLocalCourseIfExists(MA2001.getLocalCode()));
    }

    @Test
    public void getFilteredLocalCourseList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredLocalCourseList()
                .remove(0));
    }

    @Test
    public void equals() {
        LocalCourseCatalogue localCourseCatalogue =
                new LocalCourseCatalogueBuilder().withLocalCourse(CS2030S).withLocalCourse(CS2040S).build();
        LocalCourseCatalogue differentLocalCourseCatalogue = new LocalCourseCatalogue();
        UserPrefs userPrefs = new UserPrefs();
        PartnerCourseCatalogue partnerCourseCatalogue =
                new PartnerCourseCatalogueBuilder().withPartnerCourse(COMP1000).withPartnerCourse(COMP2000).build();
        UniversityCatalogue universityCatalogue = getTypicalUniversityCatalogue();
        NoteCatalogue noteCatalogue = getTypicalNoteCatalogue();


        // same values -> returns true
        modelManager = new SeplendidModelManager(localCourseCatalogue, userPrefs,
                partnerCourseCatalogue, universityCatalogue, noteCatalogue);
        SeplendidModelManager modelManagerCopy = new SeplendidModelManager(localCourseCatalogue, userPrefs,
                partnerCourseCatalogue, universityCatalogue, noteCatalogue);
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different localCourseCatalogue -> returns false
        assertFalse(modelManager.equals(new SeplendidModelManager(differentLocalCourseCatalogue, userPrefs,
                partnerCourseCatalogue, universityCatalogue, noteCatalogue)));

        // different filteredList -> returns false
        modelManager.updateFilteredLocalCourseList(unused -> false);
        assertFalse(modelManager.equals(new SeplendidModelManager(localCourseCatalogue, userPrefs,
                partnerCourseCatalogue, universityCatalogue, noteCatalogue)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredLocalCourseList(PREDICATE_SHOW_ALL_LOCAL_COURSES);

        // different userPrefs -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setLocalCourseCatalogueFilePath(Paths.get("differentFilePath"));
        assertFalse(modelManager.equals(new SeplendidModelManager(localCourseCatalogue, differentUserPrefs,
                partnerCourseCatalogue, universityCatalogue, noteCatalogue)));
    }
}
