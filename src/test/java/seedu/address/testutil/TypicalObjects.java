package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.localcourse.LocalCourse;

/**
 * A utility class containing a list of SEPlendid objects to use in tests.
 */
public class TypicalObjects {

    public static final String TYPICAL_LOCAL_COURSE_CODE = "CS2103";
    public static final String TYPICAL_LOCAL_COURSE_NAME = "Software Engineering";

    public static final String EDGE_CASE_VALID_LOCAL_COURSE_CODE = "S";
    public static final String EDGE_CASE_VALID_LOCAL_COURSE_NAME = " Software Testing";
    public static final String INVALID_LOCAL_COURSE_CODE = "$HOW2BECOMERICH";
    public static final String INVALID_LOCAL_COURSE_NAME = " ";

    public static final LocalCourse CS2040S = new LocalCourseBuilder().withLocalCode("CS2040S")
            .withLocalName("Data Structures & Algorithms").build();
    public static final LocalCourse CS3230 = new LocalCourseBuilder().withLocalCode("CS3230")
            .withLocalName("Design & Analysis of Algorithms").build();
    public static final LocalCourse EDGE_CASE_VALID_LOCAL_COURSE = new LocalCourseBuilder()
            .withLocalCode(EDGE_CASE_VALID_LOCAL_COURSE_CODE).withLocalName(EDGE_CASE_VALID_LOCAL_COURSE_NAME).build();


    private TypicalObjects() {
    } // prevents instantiation

    /**
     * Returns an {@code LocalCourseCatalogue} with all the typical localCourses.
     */
    public static LocalCourseCatalogue getTypicalLocalCourseCatalogue() {
        LocalCourseCatalogue localCourseCatalogue = new LocalCourseCatalogue();
        for (LocalCourse localCourse : getTypicalLocalCourses()) {
            localCourseCatalogue.addLocalCourse(localCourse);
        }
        return localCourseCatalogue;
    }

    public static List<LocalCourse> getTypicalLocalCourses() {
        return new ArrayList<>(Arrays.asList(CS2040S, CS3230));
    }
}
