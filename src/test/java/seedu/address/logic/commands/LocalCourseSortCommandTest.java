package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertSeplendidCommandSuccess;
import static seedu.address.testutil.TypicalObjects.CS1231S;
import static seedu.address.testutil.TypicalObjects.CS2040S;
import static seedu.address.testutil.TypicalObjects.CS3230;
import static seedu.address.testutil.TypicalObjects.MA2001;
import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalMappingCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalNoteCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalCode;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalName;

public class LocalCourseSortCommandTest {
    private SeplendidModel model;
    private SeplendidModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(getTypicalLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue(), getTypicalNoteCatalogue(),
                getTypicalMappingCatalogue());
        expectedModel = new SeplendidModelManager(model.getLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue(), getTypicalNoteCatalogue(),
                getTypicalMappingCatalogue());

    }

    @Test
    public void execute_sortByLocalCode_success() {
        LocalCourseComparatorByLocalCode comparator = new LocalCourseComparatorByLocalCode();
        LocalCourseSortCommand localCourseSortCommand = new LocalCourseSortCommand(comparator);
        expectedModel.updateSortedLocalList(comparator);

        assertSeplendidCommandSuccess(localCourseSortCommand, model,
                LocalCourseSortCommand.MESSAGE_SUCCESS,
                expectedModel);

        List<LocalCourse> sortedList = new ArrayList<>();
        sortedList.add(CS1231S);
        sortedList.add(CS2040S);
        sortedList.add(CS3230);
        sortedList.add(MA2001);

        assertEquals(sortedList, model.getSortedLocalCourseList());
    }

    @Test
    public void execute_sortByLocalName_success() {
        LocalCourseComparatorByLocalName comparator = new LocalCourseComparatorByLocalName();
        LocalCourseSortCommand localCourseSortCommand = new LocalCourseSortCommand(comparator);
        expectedModel.updateSortedLocalList(comparator);

        assertSeplendidCommandSuccess(localCourseSortCommand, model,
                LocalCourseSortCommand.MESSAGE_SUCCESS,
                expectedModel);

        List<LocalCourse> sortedList = new ArrayList<>();
        sortedList.add(CS2040S);
        sortedList.add(CS3230);
        sortedList.add(CS1231S);
        sortedList.add(MA2001);

        assertEquals(sortedList, model.getSortedLocalCourseList());
    }

    @Test
    public void equals() {
        Comparator<LocalCourse> localCourseComparatorByLocalCode = new LocalCourseComparatorByLocalCode();
        Comparator<LocalCourse> localCourseComparatorByLocalName = new LocalCourseComparatorByLocalName();

        LocalCourseSortCommand localCourseSortCommandByLocalCode =
                new LocalCourseSortCommand(localCourseComparatorByLocalCode);
        LocalCourseSortCommand localCourseSortCommandByLocalName =
                new LocalCourseSortCommand(localCourseComparatorByLocalName);

        // same object -> returns true
        assertTrue(localCourseSortCommandByLocalCode.equals(localCourseSortCommandByLocalCode));

        // same values -> returns true
        LocalCourseSortCommand localCourseSortCommandByLocalCodeCopy =
                new LocalCourseSortCommand(localCourseComparatorByLocalCode);
        assertTrue(localCourseSortCommandByLocalCode.equals(localCourseSortCommandByLocalCodeCopy));

        // different types -> returns false
        assertFalse(localCourseSortCommandByLocalCode.equals(1));

        // null -> returns false
        assertFalse(localCourseSortCommandByLocalCode.equals(null));

        // different task -> returns false
        assertFalse(localCourseSortCommandByLocalCode.equals(localCourseSortCommandByLocalName));
    }
}
